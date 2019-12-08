package br.edu.utfpr.dao;

import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class AttackItemDao extends AbstractDao<AttackItem> {

    private final String INSERT = "INSERT INTO attackitem(name, attack, speed, description, job, rarity) VALUES(?, ?, ?, ?, ?, ?);";
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public boolean insert(AttackItem attackItem) {
        boolean state;
        super.openConnection();
        try {
            pstm = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, attackItem.getName());
            pstm.setInt(2, attackItem.getAttack());
            pstm.setInt(3, attackItem.getSpeed());
            pstm.setString(4, attackItem.getDescription());
            pstm.setString(5, attackItem.getJob().getDescription());
            pstm.setString(6, attackItem.getRarity().getDescription());
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                attackItem.setId(rs.getInt(1));
            }
            state = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            state = false;
        } finally {
            super.closeConnection();
        }
        return state;
    }

    @Override
    public boolean delete(int id) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("DELETE FROM attackItem WHERE ID = ?");
            pstm.setInt(1, id);
            return pstm.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to delete: " + ex.getMessage());
            return false;
        } finally {
            super.closeConnection();
        }
    }

    @Override
    public boolean update(AttackItem attackItem) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("UPDATE attackitem SET name = ?, attack = ?, speed = ?, description = ?, job = ?, rarity = ? WHERE id = ?");
            pstm.setString(1, attackItem.getName());
            pstm.setInt(2, attackItem.getAttack());
            pstm.setInt(3, attackItem.getSpeed());
            pstm.setString(4, attackItem.getDescription());
            pstm.setString(5, attackItem.getJob().getDescription());
            pstm.setString(6, attackItem.getRarity().getDescription());
            pstm.setInt(7, attackItem.getId());

            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public AttackItem getAttackItemById(int index) {
        //System.out.println("AttacKitemById");
        AttackItem attackItem = new AttackItem();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM attackItem WHERE id = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            while (rs.next()) {
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItem;
    }
    
    public AttackItem getAttackItemByCharId(int characterIndex) { //informa o id do char
        AttackItem attackItem = new AttackItem();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT attackitem.* FROM attackItem JOIN character ON (character.idattack = attackitem.id) WHERE character.id = ?");
            pstm.setInt(1, characterIndex);
            rs = pstm.executeQuery();
            while (rs.next()) {
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItem;
    }

    
    public boolean getAttackItemByName(String nome) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT name FROM attackitem WHERE name = ?");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString("name").equals(nome);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return false;
    }
    
    public AttackItem getAtkItem(String nome) {
        super.openConnection();
        AttackItem attackItem = new AttackItem();
        try {
            pstm = connection.prepareCall("SELECT * FROM attackitem WHERE name = ?");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            if (rs.next()) {
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItem;
    }

    public Vector<String> getAI(String query) { //if not empty then filter, else dont
        Vector<String> attackItemList = new Vector<>();
        super.openConnection();
        try {
            if(!query.isEmpty()){
                pstm = connection.prepareStatement("SELECT name FROM attackItem where job = ?");
                pstm.setString(1, query);
            } else {
                pstm = connection.prepareStatement("SELECT name FROM attackItem");
            }          
            rs = pstm.executeQuery();
            while (rs.next()) {
                attackItemList.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItemList;
    }
    
    public int getCount() {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT count(*) FROM attackItem");
            rs = pstm.executeQuery();
            if(rs.next()){
                return rs.getInt("count");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return 0;
    }
    
    public List<AttackItem> getAttackItems() {
        List<AttackItem> attackItemList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM attackItem");
            rs = pstm.executeQuery();
            while (rs.next()) {
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                attackItemList.add(attackItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItemList;
    }
    
    public boolean getBoundedItem(int index) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("select idAttack from character join attackitem on (attackitem.id = character.idAttack) where idAttack = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            if (rs.next()) { //possui tuplas
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return false;
    }
    
    public List<AttackItem> getAttackItems(String rarity) {
        List<AttackItem> attackItemList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM attackItem WHERE rarity = ?");
            pstm.setString(1, rarity);
            rs = pstm.executeQuery();
            if(rs.getRow() == 0){
                System.out.println("Dont have any results that met this rarity!!");
            }
            while (rs.next()) {
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                attackItemList.add(attackItem);
            }           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItemList;
    }

    public List<AttackItem> search(String field, String query, int index, int value) {
        List<AttackItem> attackItemList = new ArrayList<>();
        super.openConnection();
        try {
            if (index == 0) {
                pstm = connection.prepareCall("SELECT * FROM attackItem WHERE " + field + " = ?");
                if (value == 1) {
                    pstm.setInt(1, Integer.parseInt(query));
                } else {
                    pstm.setString(1, query);
                }
            } else if (index == 1) {
                pstm = connection.prepareCall("SELECT * FROM attackItem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, '%' + (query + '%').toUpperCase());
            } else if (index == 2) {
                pstm = connection.prepareCall("SELECT * FROM attackItem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, (query + '%').toUpperCase());
            } else {
                pstm = connection.prepareCall("SELECT * FROM attackItem WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, ('%' + query).toUpperCase());
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                attackItemList.add(attackItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItemList;
    }

    public List<AttackItem> searchFilter(ArrayList<String> sql) {
        List<AttackItem> attackItems = new ArrayList<>();
        String query = "";
        super.openConnection();
        try {
            for (String s : sql) {
                query += s + ",";
            }
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            pstm = connection.prepareCall("SELECT " + query + " FROM attackitem");
            System.out.println("SELECT " + query + " FROM attackitem");
            rs = pstm.executeQuery();
            while (rs.next()) {
                AttackItem attackItem = new AttackItem();
                if (sql.contains("Id")) {
                    attackItem.setId(rs.getInt("id"));
                }
                if (sql.contains("Name")) {
                    attackItem.setName(rs.getString("name"));
                }
                if (sql.contains("Attack")) {
                    attackItem.setAttack(rs.getInt("attack"));
                }
                if (sql.contains("Speed")) {
                    attackItem.setSpeed(rs.getInt("speed"));
                }
                if (sql.contains("Description")) {
                    attackItem.setDescription(rs.getString("description"));
                }
                if (sql.contains("Job")) {
                    attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                }
                if (sql.contains("Rarity")) {
                    attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                }
                attackItems.add(attackItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItems;
    }

    public List<AttackItem> searchFill(HashMap<String, String> sql) {
        List<AttackItem> attackItems = new ArrayList<>();
        String where = "";
        super.openConnection();
        try {
            int i = 0;
            int count = 0;
            for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                if (entry.getKey().equals("Id") || entry.getKey().equals("Name") || entry.getKey().equals("Attack") || entry.getKey().equals("Speed")
                        || entry.getKey().equals("Description") || entry.getKey().equals("Job") || entry.getKey().equals("Rarity")) {
                    where += entry.getKey() + " = ? AND ";
                    count++;
                }
                i++;
            }
            if (where.endsWith("AND ") && count > 0) {
                where = where.substring(0, where.length() - 4);
            }

            //System.out.println("Query: " + query + " Where: " + where);
            if (count > 0) {
                pstm = connection.prepareCall("SELECT * FROM attackitem WHERE " + where);
                i = 1;
                for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                    if (entry.getKey().equals("Id") || entry.getKey().equals("Attack") || entry.getKey().equals("Speed")) {
                        pstm.setInt(i, Integer.parseInt(entry.getValue()));
                    } else {
                        pstm.setString(i, entry.getValue());
                    }
                    i++;
                }
            } else {
                pstm = connection.prepareCall("SELECT * FROM attackitem");
            }

            rs = pstm.executeQuery();
            while (rs.next()) {
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt("id"));
                attackItem.setName(rs.getString("name"));
                attackItem.setAttack(rs.getInt("attack"));
                attackItem.setSpeed(rs.getInt("speed"));
                attackItem.setDescription(rs.getString("description"));
                attackItem.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString("rarity").toUpperCase()));
                attackItems.add(attackItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return attackItems;
    }
}
