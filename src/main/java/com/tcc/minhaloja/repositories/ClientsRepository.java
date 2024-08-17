package com.tcc.minhaloja.repositories;


import com.tcc.minhaloja.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientsRepository {

@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClients() {
        var clients = new ArrayList<Client>();

        String sql = "SELECT * FROM clients ORDER BY id DESC";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);

        while (rows.next()) {
            Client client = new Client();

            client.setId(rows.getInt("id"));
            client.setFirstName(rows.getString("firstname"));
            client.setLastName(rows.getString("lastname"));
            client.setEmail(rows.getString("email"));
            client.setPhone(rows.getString("phone"));
            client.setAddress(rows.getString("address"));
            client.setCreatedAt(rows.getString("created_at"));

            clients.add(client);
        }
        return clients;
    }


    public Client getClient(int id) {
        String sql = "SELECT * FROM clients WHERE id=?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, id);

        if (rows.next()) {
            Client client = new Client();
            client.setId(rows.getInt("id"));
            client.setFirstName(rows.getString("firstname"));
            client.setLastName(rows.getString("lastname"));
            client.setEmail(rows.getString("email"));
            client.setPhone(rows.getString("phone"));
            client.setAddress(rows.getString("address"));
            client.setCreatedAt(rows.getString("created_at"));
            return client;
        }

        return null;
    }



    public Client getClient(String email) {
        String sql = "SELECT * FROM clients WHERE email=?";

        SqlRowSet rows = jdbcTemplate.queryForRowSet(sql, email);

        if (rows.next()) {
            Client client = new Client();
            client.setId(rows.getInt("id"));
            client.setFirstName(rows.getString("firstname"));
            client.setLastName(rows.getString("lastname"));
            client.setEmail(rows.getString("email"));
            client.setPhone(rows.getString("phone"));
            client.setAddress(rows.getString("address"));
            client.setCreatedAt(rows.getString("created_at"));
            return client;
        }

        return null;
    }


    public Client createClient(Client client) {
        String sql = "INSERT INTO clients (firstname, lastname, email, phone, " +
                "address, created_at) VALUES (?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"ID"});
            ps.setString(1, client.getFirstName());
            ps.setString(2, client.getLastName());
            ps.setString(3, client.getEmail());
            ps.setString(4, client.getPhone());
            ps.setString(5, client.getAddress());
            ps.setString(6, client.getCreatedAt());
            return ps;
        }, keyHolder);

        Number key = keyHolder.getKey();
        int id = (key != null) ? key.intValue() : 0;
        return getClient(id);
    }


    public Client updateClient(Client client) {
        String sql = "UPDATE clients SET firstname=?, lastname=?, email=?, " +
                "phone=?, address=?, created_at=? WHERE id=?";

        jdbcTemplate.update(sql, client.getFirstName(), client.getLastName(),
                client.getEmail(), client.getPhone(), client.getAddress(),
                client.getCreatedAt(), client.getId());

        return getClient(client.getId());
    }


    public void deleteClient(int id) {
        String sql = "DELETE FROM clients WHERE id=?";
        jdbcTemplate.update(sql, id);
    }






}
