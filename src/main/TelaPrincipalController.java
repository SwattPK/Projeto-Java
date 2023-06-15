/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import db.DB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author gabrielbezerra
 */
public class TelaPrincipalController {
    
//    public void pegarUsuarios(){
//        String senha = null;
//        boolean user = true;
//        Connection conn = null;
//        Statement st = null;
//        ResultSet rs = null;
//        try{
//            conn = DB.getConnection();
//            st = conn.createStatement();
//            rs = st.executeQuery(String.format("select * from %s "
//                    + "where cpf = \"%s\"",cargo, cpf));
//            if(!rs.next()){
//                user = false;
//            }
//            else{
//                senha = rs.getString("senha");
//            }
//        }
//        catch(SQLException e){
//            e.printStackTrace();
//        }
//        finally{
//            DB.closeStatement(st);
//            DB.closeConnection();
//        }
//    }
    
    public void adicionarMembro() throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("popUpChoice.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Label question = new Label();
        question.setLayoutX(200);
        question.setLayoutY(200);
        question.setText("Quantos membros você deseja adicionar?");
        TextField quantidadeMembros = new TextField();
        System.out.println(root);
        AnchorPane anchorChoice = (AnchorPane) root.getChildrenUnmodifiable().get(0);
        anchorChoice.getChildren().addAll(question,quantidadeMembros);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}