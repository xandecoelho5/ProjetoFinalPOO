package br.edu.utfpr.dao;

import br.edu.utfpr.entity.AttackItem;
import br.edu.utfpr.entity.DefenseItem;
import br.edu.utfpr.enumeration.Gear;
import br.edu.utfpr.enumeration.Job;
import br.edu.utfpr.enumeration.Rarity;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JOptionPane;

public class CharacterDao extends AbstractDao<br.edu.utfpr.entity.Character> {

    private ResultSet rs;
    private final String INSERT = "INSERT INTO character(data, nickname, sex, hp, attack, defense, speed, job, idattack, iddefense) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private PreparedStatement pstm;
    private final AttackItemDao attackItemDao = new AttackItemDao();
    private final DefenseItemDao defenseItemDao = new DefenseItemDao();

    public CharacterDao() {
    }

    @Override
    public boolean insert(br.edu.utfpr.entity.Character character) {
        boolean state;
        super.openConnection();
        try {
            pstm = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setDate(1, Date.valueOf(character.getDate()));
            pstm.setString(2, character.getNickname());
            pstm.setString(3, character.getSex());
            pstm.setInt(4, character.getHp());
            pstm.setInt(5, character.getAttack());
            pstm.setInt(6, character.getDefense());
            pstm.setInt(7, character.getSpeed());
            pstm.setString(8, character.getJob().getDescription());
            pstm.setInt(9, 999);
            pstm.setInt(10, 999);
            pstm.executeUpdate();

            rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                character.setId(rs.getInt(1));
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
            pstm = connection.prepareStatement("DELETE FROM character WHERE ID = ?");
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
    public boolean update(br.edu.utfpr.entity.Character character) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("UPDATE character SET data = ?, nickname = ?, sex = ?, hp = ?, attack = ?, defense = ?, speed = ?, job = ? WHERE id = ?");
            pstm.setDate(1, Date.valueOf(character.getDate()));
            pstm.setString(2, character.getNickname());
            pstm.setString(3, character.getSex());
            pstm.setInt(4, character.getHp());
            pstm.setInt(5, character.getAttack());
            pstm.setInt(6, character.getDefense());
            pstm.setInt(7, character.getSpeed());
            pstm.setString(8, character.getJob().getDescription());
            pstm.setInt(9, character.getId());

            return pstm.executeUpdate() != 0; //executa INSERT/DELETE/UPDATE/some DDL    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public boolean update(br.edu.utfpr.entity.Character character, int index, int type) {
        super.openConnection();
        try {
            System.out.println("char" + character + "Ind: " + index + " type" + type);
            if (type == 0) { // 0 para attackitem e 1 para defense
                pstm = connection.prepareStatement("UPDATE character SET idattack = ? WHERE id = ?");
            } else {
                pstm = connection.prepareStatement("UPDATE character SET iddefense = ? WHERE id = ?");
            }
            pstm.setInt(1, index);
            pstm.setInt(2, character.getId());

            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public boolean update(br.edu.utfpr.entity.Character character, int attack, int speed, boolean newValue) { //se true 
        super.openConnection();
        try {
            System.out.println("UPDATE character SET attack = " + attack + " " + speed + " = ? WHERE id = " + character.getId() + " Attack:" + character.getAttack() + "Def: " + character.getSpeed());
            pstm = connection.prepareStatement("UPDATE character SET attack = ?, speed = ? WHERE id = ?");
            pstm.setInt(1, newValue ? character.getAttack() + attack : character.getAttack() - attack);
            pstm.setInt(2, newValue ? character.getSpeed() + speed : character.getSpeed() - speed);
            pstm.setInt(3, character.getId());

            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public boolean update(br.edu.utfpr.entity.Character character, int defense, boolean newValue) {
        super.openConnection();
        try {
            pstm = connection.prepareStatement("UPDATE character SET defense = ? WHERE id = ?");
            pstm.setInt(1, newValue ? character.getDefense() + defense : character.getDefense() - defense);
            pstm.setInt(2, character.getId());

            return pstm.executeUpdate() != 0;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to update: " + ex.getMessage());
            return false;
        }
    }

    public br.edu.utfpr.entity.Character getCharacterById(int index) { 
        br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                    + "join defenseitem on (character.iddefense = defenseitem.id) WHERE character.id = ?");
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            while (rs.next()) {
                character.setId(rs.getInt(1));
                character.setDate(rs.getDate(2).toLocalDate());
                character.setNickname(rs.getString(3));
                character.setSex(rs.getString(4));
                character.setHp(rs.getInt(5));
                character.setAttack(rs.getInt(6));
                character.setDefense(rs.getInt(7));
                character.setSpeed(rs.getInt(8));
                character.setJob(Job.valueOf(rs.getString(9).toUpperCase()));
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt(12));
                attackItem.setName(rs.getString(13));
                attackItem.setAttack(rs.getInt(14));
                attackItem.setSpeed(rs.getInt(15));
                attackItem.setDescription(rs.getString(16));
                attackItem.setJob(Job.valueOf(rs.getString(17).toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString(18).toUpperCase()));
                character.setAttackItem(attackItem);
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt(19));
                defenseItem.setName(rs.getString(20));
                defenseItem.setDefense(rs.getInt(21));
                defenseItem.setGear(Gear.valueOf(rs.getString(22).toUpperCase()));
                defenseItem.setDescription(rs.getString(23));
                defenseItem.setJob(Job.valueOf(rs.getString(24).toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString(25).toUpperCase()));
                character.setDefenseItem(defenseItem);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return character;
    }

    public br.edu.utfpr.entity.Character getCharacter(String name) {
        br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT * FROM character WHERE nickname = ?");
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                character.setId(rs.getInt("id"));
                character.setDate(rs.getDate("data").toLocalDate());
                character.setNickname(rs.getString("nickname"));
                character.setSex(rs.getString("sex"));
                character.setHp(rs.getInt("hp"));
                character.setAttack(rs.getInt("attack"));
                character.setDefense(rs.getInt("defense"));
                character.setSpeed(rs.getInt("speed"));
                character.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                character.setAttackItem(new AttackItemDao().getAttackItemById(rs.getInt("idattack")));
                character.setDefenseItem(new DefenseItemDao().getDefenseItemById(rs.getInt("iddefense")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return character;
    }

    public Vector<String> getCharacterNames() {
        Vector<String> characterList = new Vector<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT nickname FROM character");
            rs = pstm.executeQuery();
            while (rs.next()) {
                characterList.add(rs.getString("nickname"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }
    
    public int getCharByItemIndex(int index, int value){ //value 0 = defItem, value 1 = attackitem
        super.openConnection();
        try {
            if(value == 0){
                pstm = connection.prepareCall("select character.id from character join defenseitem on (defenseitem.id = character.idDefense) where idDefense = ?");
            } else {
                pstm = connection.prepareCall("select character.id from character join attackitem on (attackitem.id = character.idAttack) where idAttack = ?");
            }         
            pstm.setInt(1, index);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return 0;      
    }
    
    public ArrayList<br.edu.utfpr.entity.Character> getCharacterStats(String name) { //maybe mostrar os itens sepa, dependendo da existencia dos mesmos
        ArrayList<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT hp, attack, defense, speed FROM character WHERE nickname = ?");
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            while (rs.next()) {
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                character.setHp(rs.getInt("hp"));
                character.setAttack(rs.getInt("attack"));
                character.setDefense(rs.getInt("defense"));
                character.setSpeed(rs.getInt("speed"));
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }
/*
    public List<br.edu.utfpr.entity.Character> getCharacters() {
        List<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM character");
            rs = pstm.executeQuery();
            while (rs.next()) {
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                character.setId(rs.getInt("id"));
                character.setDate(rs.getDate("data").toLocalDate());
                character.setNickname(rs.getString("nickname"));
                character.setSex(rs.getString("sex"));
                character.setHp(rs.getInt("hp"));
                character.setAttack(rs.getInt("attack"));
                character.setDefense(rs.getInt("defense"));
                character.setSpeed(rs.getInt("speed"));
                character.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                character.setAttackItem(attackItemDao.getAttackItemById(rs.getInt("idattack")));
                character.setDefenseItem(defenseItemDao.getDefenseItemById(rs.getInt("iddefense")));
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }
*/
    public List<br.edu.utfpr.entity.Character> getCharactersAll() {
        //System.out.println("Characterlist");
        List<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        super.openConnection();
        try {
            pstm = connection.prepareStatement("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                    + " join defenseitem on (character.iddefense = defenseitem.id)");
            rs = pstm.executeQuery();
            while (rs.next()) {
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                character.setId(rs.getInt(1));
                character.setDate(rs.getDate(2).toLocalDate());
                character.setNickname(rs.getString(3));
                character.setSex(rs.getString(4));
                character.setHp(rs.getInt(5));
                character.setAttack(rs.getInt(6));
                character.setDefense(rs.getInt(7));
                character.setSpeed(rs.getInt(8));
                character.setJob(Job.valueOf(rs.getString(9).toUpperCase()));
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt(12));
                attackItem.setName(rs.getString(13));
                attackItem.setAttack(rs.getInt(14));
                attackItem.setSpeed(rs.getInt(15));
                attackItem.setDescription(rs.getString(16));
                attackItem.setJob(Job.valueOf(rs.getString(17).toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString(18).toUpperCase()));
                character.setAttackItem(attackItem);
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt(19));
                defenseItem.setName(rs.getString(20));
                defenseItem.setDefense(rs.getInt(21));
                defenseItem.setGear(Gear.valueOf(rs.getString(22).toUpperCase()));
                defenseItem.setDescription(rs.getString(23));
                defenseItem.setJob(Job.valueOf(rs.getString(24).toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString(25).toUpperCase()));
                character.setDefenseItem(defenseItem);
                //System.out.println("Caracter" + character);
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }

    public List<br.edu.utfpr.entity.Character> search(String field, String query, int index, int value) {

        List<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        super.openConnection();
        try {
            if (index == 0) {
                pstm = connection.prepareCall("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                        + " join defenseitem on (character.iddefense = defenseitem.id) WHERE character." + field + " = ?");
                if (value == 1) {
                    pstm.setInt(1, Integer.parseInt(query));
                } else {
                    pstm.setString(1, query);
                }
            } else if (index == 1) {
                pstm = connection.prepareCall("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                        + " join defenseitem on (character.iddefense = defenseitem.id) WHERE upper(character." + field + "::varchar) like ?");
                pstm.setString(1, '%' + (query + '%').toUpperCase());
            } else if (index == 2) {
                pstm = connection.prepareCall("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                        + " join defenseitem on (character.iddefense = defenseitem.id) WHERE upper(character." + field + "::varchar) like ?");
                pstm.setString(1, (query + '%').toUpperCase());
            } else {
                pstm = connection.prepareCall("SELECT * FROM character join attackitem on (character.idattack = attackitem.id) "
                        + " join defenseitem on (character.iddefense = defenseitem.id) WHERE upper(character." + field + "::varchar) like ?");
                pstm.setString(1, ('%' + query).toUpperCase());
            }
            rs = pstm.executeQuery();
            while (rs.next()) {
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                character.setId(rs.getInt(1));
                character.setDate(rs.getDate(2).toLocalDate());
                character.setNickname(rs.getString(3));
                character.setSex(rs.getString(4));
                character.setHp(rs.getInt(5));
                character.setAttack(rs.getInt(6));
                character.setDefense(rs.getInt(7));
                character.setSpeed(rs.getInt(8));
                character.setJob(Job.valueOf(rs.getString(9).toUpperCase()));
                AttackItem attackItem = new AttackItem();
                attackItem.setId(rs.getInt(12));
                attackItem.setName(rs.getString(13));
                attackItem.setAttack(rs.getInt(14));
                attackItem.setSpeed(rs.getInt(15));
                attackItem.setDescription(rs.getString(16));
                attackItem.setJob(Job.valueOf(rs.getString(17).toUpperCase()));
                attackItem.setRarity(Rarity.valueOf(rs.getString(18).toUpperCase()));
                character.setAttackItem(attackItem);
                DefenseItem defenseItem = new DefenseItem();
                defenseItem.setId(rs.getInt(19));
                defenseItem.setName(rs.getString(20));
                defenseItem.setDefense(rs.getInt(21));
                defenseItem.setGear(Gear.valueOf(rs.getString(22).toUpperCase()));
                defenseItem.setDescription(rs.getString(23));
                defenseItem.setJob(Job.valueOf(rs.getString(24).toUpperCase()));
                defenseItem.setRarity(Rarity.valueOf(rs.getString(25).toUpperCase()));
                character.setDefenseItem(defenseItem);
                //System.out.println("Caracter" + character);
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }

    public List<br.edu.utfpr.entity.Character> searchFilter(TreeMap<Integer, String> sql) {
        List<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        String query = "";
        String join = "";
        super.openConnection();
        try {
            System.out.println("HASH: " + sql);

            if (sql.containsValue("IdAttack")) {
                join += " join attackitem on (character.idattack = attackitem.id) ";
                if (sql.containsValue("IdDefense")) {
                    sql.replace(sql.size() - 2, "IdAttack", "AttackItem.Id");
                    sql.replace(sql.size() - 1, "IdDefense", "AttackItem.Name");
                    sql.put(sql.size(), "AttackItem.Attack");
                    sql.put(sql.size(), "AttackItem.Speed");
                    sql.put(sql.size(), "AttackItem.Description");
                    sql.put(sql.size(), "AttackItem.Job");
                    sql.put(sql.size(), "AttackItem.Rarity");
                    sql.put(sql.size(), "IdDefense");
                } else {
                    sql.replace(sql.size() - 1, "IdAttack", "AttackItem.Id");
                    sql.put(sql.size(), "AttackItem.Name");
                    sql.put(sql.size(), "AttackItem.Attack");
                    sql.put(sql.size(), "AttackItem.Speed");
                    sql.put(sql.size(), "AttackItem.Description");
                    sql.put(sql.size(), "AttackItem.Job");
                    sql.put(sql.size(), "AttackItem.Rarity");
                }
            }
            if (sql.containsValue("IdDefense")) {
                join += " join defenseitem on (character.iddefense = defenseitem.id)";
                sql.replace(sql.size() - 1, "IdDefense", "DefenseItem.Id");
                sql.put(sql.size(), "DefenseItem.Name");
                sql.put(sql.size(), "DefenseItem.Defense");
                sql.put(sql.size(), "Gear");
                sql.put(sql.size(), "DefenseItem.Description");
                sql.put(sql.size(), "DefenseItem.Job");
                sql.put(sql.size(), "DefenseItem.Rarity");
            }

            for (HashMap.Entry<Integer, String> entry : sql.entrySet()) {
                query += entry.getValue() + ",";
            }
            if (query.endsWith(",")) {
                query = query.substring(0, query.length() - 1);
            }
            System.out.println("HASHPT2-> " + sql);
            pstm = connection.prepareCall("SELECT " + query + " FROM character" + join);
            System.out.println("SELECT " + query + " FROM character" + join);
            rs = pstm.executeQuery();
            int i;
            while (rs.next()) {
                i = 1;
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                if (sql.containsValue("Character.Id")) {
                    character.setId(rs.getInt(i));
                    i++;
                }
                if (sql.containsValue("Data")) {
                    character.setDate(rs.getDate(i).toLocalDate());
                    i++;
                }
                if (sql.containsValue("Nickname")) {
                    character.setNickname(rs.getString(i));
                    i++;
                }
                if (sql.containsValue("Sex")) {
                    character.setSex(rs.getString(i));
                    i++;
                }
                if (sql.containsValue("Hp")) {
                    character.setHp(rs.getInt(i));
                    i++;
                }
                if (sql.containsValue("Character.Attack")) {
                    character.setAttack(rs.getInt(i));
                    i++;
                }
                if (sql.containsValue("Character.Defense")) {
                    character.setDefense(rs.getInt(i));
                    i++;
                }
                if (sql.containsValue("Character.Speed")) {
                    character.setSpeed(rs.getInt(i));
                    i++;
                }
                if (sql.containsValue("Character.Job")) {
                    character.setJob(Job.valueOf(rs.getString(i).toUpperCase()));
                    i++;
                }

                if (join.contains("attackitem")) {
                    AttackItem attackItem = new AttackItem();
                    attackItem.setId(rs.getInt(i));
                    i++;
                    attackItem.setName(rs.getString(i));
                    i++;
                    attackItem.setAttack(rs.getInt(i));
                    i++;
                    attackItem.setSpeed(rs.getInt(i));
                    i++;
                    attackItem.setDescription(rs.getString(i));
                    i++;
                    attackItem.setJob(Job.valueOf(rs.getString(i).toUpperCase()));
                    i++;
                    attackItem.setRarity(Rarity.valueOf(rs.getString(i).toUpperCase()));
                    i++;
                    character.setAttackItem(attackItem);
                }
                if (join.contains("defenseitem")) {
                    DefenseItem defenseItem = new DefenseItem();
                    defenseItem.setId(rs.getInt(i));
                    i++;
                    defenseItem.setName(rs.getString(i));
                    i++;
                    defenseItem.setDefense(rs.getInt(i));
                    i++;
                    defenseItem.setGear(Gear.valueOf(rs.getString(i).toUpperCase()));
                    i++;
                    defenseItem.setDescription(rs.getString(i));
                    i++;
                    defenseItem.setJob(Job.valueOf(rs.getString(i).toUpperCase()));
                    i++;
                    defenseItem.setRarity(Rarity.valueOf(rs.getString(i).toUpperCase()));
                    character.setDefenseItem(defenseItem);
                }
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }

    public List<br.edu.utfpr.entity.Character> searchFill(HashMap<String, String> sql) {
        List<br.edu.utfpr.entity.Character> characterList = new ArrayList<>();
        String where = "";
        super.openConnection();
        try {
            int i = 0;
            int count = 0;
            for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                if (entry.getKey().equals("Id") || entry.getKey().equals("Data") || entry.getKey().equals("Nickname") || entry.getKey().equals("Sex") || entry.getKey().equals("Hp") || entry.getKey().equals("Attack")
                        || entry.getKey().equals("Defense") || entry.getKey().equals("Speed") || entry.getKey().equals("Job") || entry.getKey().equals("IdAttack") || entry.getKey().equals("IdDefense")) {
                    where += entry.getKey() + " = ? AND ";
                    count++;
                }
                i++;
            }

            if (where.endsWith("AND ") && count > 0) {
                where = where.substring(0, where.length() - 4);
            }

            System.out.println("Sql: " + sql + " Where: " + where);
            if (count > 0) { //" + query + "
                pstm = connection.prepareCall("SELECT * FROM character WHERE " + where);
                i = 1;
                for (HashMap.Entry<String, String> entry : sql.entrySet()) {
                    if (entry.getKey().equals("Id") || entry.getKey().equals("Hp") || entry.getKey().equals("Attack") || entry.getKey().equals("Defense") || entry.getKey().equals("Speed")
                            || entry.getKey().equals("IdAttack") || entry.getKey().equals("IdDefense")) {
                        pstm.setInt(i, Integer.parseInt(entry.getValue()));
                    } else {
                        pstm.setString(i, entry.getValue());
                    }
                    i++;
                }
            } else {
                pstm = connection.prepareCall("SELECT * FROM character");
            }

            //System.out.println(("SELECT " + query + " FROM character WHERE " + where));
            //System.out.println("SELECT " + query + " FROM character");
            rs = pstm.executeQuery();
            while (rs.next()) {
                br.edu.utfpr.entity.Character character = new br.edu.utfpr.entity.Character();
                character.setId(rs.getInt("id"));
                character.setDate(rs.getDate("data").toLocalDate());
                character.setNickname(rs.getString("nickname"));
                character.setSex(rs.getString("sex"));
                character.setHp(rs.getInt("hp"));
                character.setAttack(rs.getInt("attack"));
                character.setDefense(rs.getInt("defense"));
                character.setSpeed(rs.getInt("speed"));
                character.setJob(Job.valueOf(rs.getString("job").toUpperCase()));
                character.setAttackItem(new AttackItemDao().getAttackItemById(rs.getInt("idattack")));
                character.setDefenseItem(new DefenseItemDao().getDefenseItemById(rs.getInt("iddefense")));
                characterList.add(character);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Not possible to select: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return characterList;
    }

    public boolean getCharacterByNick(String nick) {
        super.openConnection();
        try {
            pstm = connection.prepareCall("SELECT nickname FROM character WHERE nickname = ?");
            pstm.setString(1, nick);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString("nickname").equals(nick);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        } finally {
            super.closeConnection();
        }
        return false;
    }
}
