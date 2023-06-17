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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import main.FXMLController;

/**
 *
 * @author gabrielbezerra
 */
public class TelaPrincipalController {
    
    private Stage stage ;
    private Pane paneChoice;
    private TextField quantidadeMembros;
    public static int idEquipe;
    
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
        scene.getStylesheets().add(getClass().getResource("fxml.css").toExternalForm());
        Label question = new Label();
        Button continuar = new Button();
        FXMLController.countEmployee = 0;
        continuar.setOnMouseClicked((MouseEvent event) -> {
            try {
                novosMembros();
            } catch (IOException ex) {
                Logger.getLogger(TelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        quantidadeMembros = new TextField();
        continuar.setText("Continuar");
        continuar.setLayoutX(140);
        continuar.setLayoutY(125);
        quantidadeMembros.setLayoutX(94);
        quantidadeMembros.setLayoutY(80);
        question.setLayoutX(50);
        question.setLayoutY(50);
        question.setText("Quantos membros você deseja adicionar?");
        System.out.println("O filho desse arrombado: "+root.getChildrenUnmodifiable().get(0));
        paneChoice = (Pane) root;
        paneChoice.getChildren().addAll(question,quantidadeMembros, continuar);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    
    public void novosMembros() throws IOException{
        stage.setWidth(790);
        stage.setHeight(500);
        FXMLController telasMembros = new FXMLController();
        telasMembros.telaCadastroMembro(quantidadeMembros, paneChoice, idEquipe,false);
    }
    
    public static void ajustarTela(Pane tela){
        Stage stage = (Stage) tela.getScene().getWindow();
        stage.setWidth(356);
        stage.setHeight(181);
    }
}
