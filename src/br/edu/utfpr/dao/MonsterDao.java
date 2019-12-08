package br.edu.utfpr.dao;

import br.edu.utfpr.entity.Monster;
import br.edu.utfpr.enumeration.Race;
import br.edu.utfpr.enumeration.Type;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class MonsterDao extends AbstractDao<Monster> {

    private final String INSERT = "INSERT INTO monster(name, hp, attack, defense, speed, race, type) VALUES(?, ?, ?, ?, ?, ?, ?);";
    private PreparedStatement pstm;
    private ResultSet rs;

    @Override
    public boolean insert(Monster monster) {
        boolean state;
        super.openConnection();
        try {
            pstm = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, monster.getName());
            pstm.setInt(2, monster.getHp());
            pstm.setInt(3, monster.getAttack());
            pstm.setInt(4, monster.getDefense());
            pstm.setInt(5, monster.getSpeed());
            pstm.setString(6, monster.getRace().getDescription());
            pstm.setString(7, monster.getType().getDescription());
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                monster.setId(rs.getInt(1));
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
            pstm = connection.prepareStatement("DELETE FROM monster WHERE ID = ?");
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
    public boolean update(Monster monster) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("UPDATE monster SET name = ?, hp = ?, attack = ?, defense = ?, speed = ?, race = ?, type = ? WHERE id = ?");
            pstm.setString(1, monster.getName());
            pstm.setInt(2, monster.getHp());
            pstm.setInt(3, monster.getAttack());
            pstm.setInt(4, monster.getDefense());
            pstm.setInt(5, monster.getSpeed());
            pstm.setString(6, monster.getRace().getDescription());
            pstm.setString(7, monster.getType().getDescription());
            pstm.setInt(8, monster.getId());

            return pstm.executeUpdate() != 0; //executa INSERT/DELETE/UPDATE/some DDL    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public Monster getMonsterById(int index) {
        Monster monster = new Monster();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM monster WHERE id = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            while (rs.next()) {
                monster.setId(rs.getInt("id"));
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monster;
    }
    
    public Monster getMonster(String name) {
        Monster monster = new Monster();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM monster WHERE name = ?");
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                monster.setId(rs.getInt("id"));
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monster;
    }

    public boolean getMonsterByName(String nome) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT name FROM monster WHERE name = ?");
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

    public List<Monster> getMonsters() {
        List<Monster> monsterList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM monster");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Monster monster = new Monster();
                monster.setId(rs.getInt("id"));
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
                monsterList.add(monster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
    
    public ArrayList<Monster> getMonsterStats(String name) {
        ArrayList<Monster> monsterList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT hp, attack, defense, speed FROM monster WHERE name = ?");
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Monster monster = new Monster();
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monsterList.add(monster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
    
    public Vector<String> getMonsterNames() {
        Vector<String> monsterList = new Vector<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT name FROM monster");
            rs = pstm.executeQuery();
            while (rs.next()) {
                monsterList.add(rs.getString("name"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
    
    public List<Monster> search(String field, String query, int index, int value) {
        List<Monster> monsterList = new ArrayList<>();
        super.openConnection();
        try {
            if (index == 0) {
                pstm = connection.prepareCall("SELECT * FROM monster WHERE " + field + " = ?");
                if (value == 1) {
                    pstm.setInt(1, Integer.parseInt(query));
                } else {
                    pstm.setString(1, query);
                }
            } else if (index == 1) {
                pstm = connection.prepareCall("SELECT * FROM monster WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, '%' + (query + '%').toUpperCase());
            } else if (index == 2) {
                pstm = connection.prepareCall("SELECT * FROM monster WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, (query + '%').toUpperCase());
            } else {
                pstm = connection.prepareCall("SELECT * FROM monster WHERE upper(" + field + "::varchar) like ? ");
                pstm.setString(1, ('%' + query).toUpperCase());
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                Monster monster = new Monster();
                monster.setId(rs.getInt("id"));
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
                monsterList.add(monster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
    
    public List<Monster> searchFilter(ArrayList<String> sql) {
        List<Monster> monsterList = new ArrayList<>();
        String query = "";
        super.openConnection();
        try {
            for (String s : sql) {
                query += s + ",";
            }
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }

            pstm = connection.prepareCall("SELECT " + query + " FROM monster");
            System.out.println("SELECT " + query + " FROM monster");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Monster monster = new Monster();
                if (sql.contains("Id")) {
                    monster.setId(rs.getInt("id"));
                }
                if (sql.contains("Name")) {
                    monster.setName(rs.getString("name"));
                }
                if (sql.contains("Hp")) {
                    monster.setHp(rs.getInt("hp"));
                }
                if (sql.contains("Attack")) {
                    monster.setAttack(rs.getInt("attack"));
                }
                if (sql.contains("Defense")) {
                    monster.setDefense(rs.getInt("defense"));
                }
                if (sql.contains("Speed")) {
                    monster.setSpeed(rs.getInt("speed"));
                }
                if (sql.contains("Race")) {
                    monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                }               
                if (sql.contains("Type")) {
                    monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
                }
                monsterList.add(monster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
    
    public List<Monster> searchFill(HashMap<String, String> sql) {
        List<Monster> monsterList = new ArrayList<>();
        String where = "";
        super.openConnection();
        try {
            int i = 0;
            int count = 0;
            for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                if (entry.getKey().equals("Id") || entry.getKey().equals("Name") || entry.getKey().equals("Hp") || entry.getKey().equals("Attack") || entry.getKey().equals("Defense") || 
                    entry.getKey().equals("Speed") || entry.getKey().equals("Race") || entry.getKey().equals("Type")) {
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
                pstm = connection.prepareCall("SELECT * FROM monster WHERE " + where);
                i = 1;
                for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                    if (entry.getKey().equals("Id") || entry.getKey().equals("Hp") || entry.getKey().equals("Attack") || entry.getKey().equals("Defense") || entry.getKey().equals("Speed")) {
                        pstm.setInt(i, Integer.parseInt(entry.getValue()));
                    } else {
                        pstm.setString(i, entry.getValue());
                    }
                    i++;
                }
            } else { 
                pstm = connection.prepareCall("SELECT * FROM monster");
            }

            //System.out.println(("SELECT " + query + " FROM character WHERE " + where));
            //System.out.println("SELECT " + query + " FROM character");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Monster monster = new Monster();
                monster.setId(rs.getInt("id"));
                monster.setName(rs.getString("name"));
                monster.setHp(rs.getInt("hp"));
                monster.setAttack(rs.getInt("attack"));
                monster.setDefense(rs.getInt("defense"));
                monster.setSpeed(rs.getInt("speed"));
                monster.setRace(Race.valueOf(rs.getString("race").toUpperCase()));
                monster.setType(Type.valueOf(rs.getString("type").toUpperCase()));
                monsterList.add(monster);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return monsterList;
    }
}
