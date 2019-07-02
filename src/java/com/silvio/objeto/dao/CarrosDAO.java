package com.silvio.objeto.dao;

import com.silvio.objeto.entidade.Carro;
import com.silvio.util.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SILVIO
 */
public class CarrosDAO {
    
    public void salvar(Carro carro){
        Connection connection = FabricaConexao.getConnection();
        try {
            PreparedStatement ps = connection.prepareCall("insert into `sistema-carros`.`carro` (`modelo`,`fabricante`,`cor`,`ano`) values (?,?,?,?)");
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().longValue()));
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            Logger.getLogger(CarrosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
