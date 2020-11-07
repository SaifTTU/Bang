import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.scene.control.Button; 
import javafx.scene.layout.*; 
import javafx.scene.image.*; 
import java.io.*; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler; 
import javafx.scene.control.Label; 
import javafx.stage.Stage; 
import java.net.*; 

import javafx.application.Application;  
import javafx.scene.Group;  
import javafx.scene.Scene;  
import javafx.scene.paint.Color;  
import javafx.scene.shape.Rectangle;  
import javafx.scene.transform.Rotate;  
import javafx.stage.Stage;  
public class GUI_Practice_Test extends Application{  
@Override  
public void start(Stage primaryStage) throws Exception {  
    // creating the rectangles 
    //Rectangle rectangle = new Rectangle(x, y, width, height);  
    Rectangle rect1 = new Rectangle(440,460,140,200);  
    Rectangle rect2 = new Rectangle(425,150,105,150);  
    Rectangle rect3 = new Rectangle(240,-50,80,114);
    Rectangle rect4 = new Rectangle(-70,-130,70,100);
    Rectangle rect5 = new Rectangle(-340,60,70,100); 
    Rectangle rect6 = new Rectangle(-400,450,70,100);
    
    Rectangle rect7 = new Rectangle(-130,725,80,114);
    Rectangle rect8 = new Rectangle(240,725,105,150); 
    
      
    // setting the color and stroke for the Rectangles    
    rect1.setFill(Color.ORANGE); 
    rect1.setStroke(Color.BLACK); 
    rect2.setFill(Color.DARKGREY);   
    rect2.setStroke(Color.BLACK); 
    
    rect3.setFill(Color.DARKGREY);  
    rect3.setStroke(Color.BLACK); 
    
    rect4.setFill(Color.DARKGREY);  
    rect4.setStroke(Color.BLACK); 
    
    rect5.setFill(Color.DARKGREY);  
    rect5.setStroke(Color.BLACK); 
    
    rect6.setFill(Color.DARKGREY);  
    rect6.setStroke(Color.BLACK);
    
    rect7.setFill(Color.DARKGREY);  
    rect7.setStroke(Color.BLACK);
    
    rect8.setFill(Color.DARKGREY);  
    rect8.setStroke(Color.BLACK);
      
    // instantiating the Rotate class.   
    Rotate rotate = new Rotate();  
      
    //setting properties for the rotate object.   
    rotate.setAngle(45);  
    rotate.setPivotX(100);  
    rotate.setPivotY(100);  
      
    //rotating the 2nd rectangle.   
    rect2.getTransforms().add(rotate);  
    rect3.getTransforms().add(rotate);
    rect3.getTransforms().add(rotate);  
    
    rect4.getTransforms().add(rotate);
    rect4.getTransforms().add(rotate);
    rect4.getTransforms().add(rotate);
    
    
    rect5.getTransforms().add(rotate);
    rect5.getTransforms().add(rotate);
    rect5.getTransforms().add(rotate);
    rect5.getTransforms().add(rotate);
    
    rect6.getTransforms().add(rotate);
    rect6.getTransforms().add(rotate);
    rect6.getTransforms().add(rotate);
    rect6.getTransforms().add(rotate);
    rect6.getTransforms().add(rotate);
    
    rect7.getTransforms().add(rotate);
    rect7.getTransforms().add(rotate);
    rect7.getTransforms().add(rotate);
    rect7.getTransforms().add(rotate);
    rect7.getTransforms().add(rotate);
    rect7.getTransforms().add(rotate);
    
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    rect8.getTransforms().add(rotate);
    
    Rectangle dice1 = new Rectangle(375,270,40,40);
     dice1.setFill(Color.ORANGE); 
     dice1.setStroke(Color.BLACK);
     Rectangle dice2 = new Rectangle(425,270,40,40);
     dice2.setFill(Color.ORANGE); 
     dice2.setStroke(Color.BLACK);
     Rectangle dice3 = new Rectangle(475,270,40,40);
     dice3.setFill(Color.ORANGE); 
     dice3.setStroke(Color.BLACK);
     Rectangle dice4 = new Rectangle(525,270,40,40);
     dice4.setFill(Color.ORANGE); 
     dice4.setStroke(Color.BLACK);
     Rectangle dice5 = new Rectangle(575,270,40,40);
     dice5.setFill(Color.ORANGE); 
     dice5.setStroke(Color.BLACK);
     
     
     
     
     
     
     Group group = new Group();
      
     Button proceed = new Button("Proceed");
     Button end = new Button("End");
     proceed.setLayoutX(100.0f); 
     end.setLayoutX(850.0f); 
     proceed.setLayoutY(100+ (550.0f));  //like the setX for buttons
     end.setLayoutY(100+ (550.0f)); 
     
     proceed.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 1
             @Override public void handle(ActionEvent e) {
                  System.out.println("one");
             }
      });
      
      end.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 2
             @Override public void handle(ActionEvent e){
                  System.out.println("two");
             }
        
      });
     
     
     
     
     
     
     
     
     group.getChildren().add(proceed);
     group.getChildren().add(end);
     /*
     group.getChildren().add(dice1); 
     group.getChildren().add(dice2); 
     group.getChildren().add(dice3); 
     group.getChildren().add(dice4);
     group.getChildren().add(dice5); */

    
        Dice dice = new Dice();
        int hand[] = dice.makeHand();
        
        // create a input stream 
        FileInputStream input = new FileInputStream("images\\"+hand[0]+".jpg");
        FileInputStream input2 = new FileInputStream("images\\"+hand[1]+".jpg"); 
        FileInputStream input3 = new FileInputStream("images\\"+hand[2]+".jpg");
        FileInputStream input4 = new FileInputStream("images\\"+hand[3]+".jpg");
        FileInputStream input5 = new FileInputStream("images\\"+hand[4]+".jpg");
        FileInputStream input6 = new FileInputStream("images\\"+hand[5]+".jpg"); 
        
        System.out.println(hand[0]);
        System.out.println(hand[1]);
        System.out.println(hand[2]);
        System.out.println(hand[3]);
        System.out.println(hand[4]);
        System.out.println(hand[5]);

        // set title for the stage 
        //s.setTitle("creating buttons"); 
  
        
  
        // create a image 
        Image i = new Image(input);
        Image i2 = new Image(input2);
        Image i3 = new Image(input3);
        Image i4 = new Image(input4);
        Image i5 = new Image(input5);
        Image i6 = new Image(input6); 
  
        // create a image View 
        ImageView iw = new ImageView(i);
        ImageView iw2 = new ImageView(i2);
        ImageView iw3 = new ImageView(i3);
        ImageView iw4 = new ImageView(i4);
        ImageView iw5 = new ImageView(i5);
        ImageView iw6 = new ImageView(i6);
 
  
        // create a button 
        Button b1 = new Button("", iw); 
        b1.setLayoutY(270.0f); //375,270 
        b1.setLayoutX(350.0f); //375,270 
        Button b2 = new Button("", iw2);
        b2.setLayoutY(270.0f); //375,270 
        b2.setLayoutX(400.0f); //375,270
        Button b3 = new Button("", iw3); 
        b3.setLayoutY(270.0f); //375,270 
        b3.setLayoutX(450.0f); //375,270
        Button b4 = new Button("", iw4);
        b4.setLayoutY(270.0f); //375,270 
        b4.setLayoutX(500.0f); //375,270
        Button b5 = new Button("", iw5); 
        b5.setLayoutY(270.0f); //375,270 
        b5.setLayoutX(550.0f); //375,270
        Button b6 = new Button("", iw6);
        b6.setLayoutY(270.0f); //375,270 
        b6.setLayoutX(600.0f); //375,270
  
        // create a stack pane 
        //TilePane group = new TilePane(); 
        
        //group.setLayoutX(50);
        //group.setLayoutY(50);
        
        
        // create a label 
        Label l = new Label(""); 
        Label l2 = new Label("");
        Label l3 = new Label(""); 
        Label l4 = new Label("");
        Label l5 = new Label(""); 
        Label l6 = new Label("");
  
        b1.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 1
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[0]);
             }
        
        });
        b2.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 2
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[1]);
             }
        
        });
        b3.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 1
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[2]);
             }
        
        });
        b4.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 2
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[3]);
             }
        
        });
        b5.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 1
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[4]);
             }
        
        });
        b6.setOnAction(new EventHandler<ActionEvent>() { //BUTTON 2
             @Override public void handle(ActionEvent e){
                  System.out.println(hand[5]);
             }
        
        });

  
        /* when button is pressed 
        b1.setOnAction(event); 
        b2.setOnAction(event); 
        b3.setOnAction(event); 
        b4.setOnAction(event); 
        b5.setOnAction(event); 
        b6.setOnAction(event); */
  
        // add button 
        group.getChildren().add(b1); 
        group.getChildren().add(b2);
        group.getChildren().add(b3); 
        group.getChildren().add(b4);
        group.getChildren().add(b5); 
        group.getChildren().add(b6);
        
        group.getChildren().add(l); 
        group.getChildren().add(l2);
        group.getChildren().add(l3); 
        group.getChildren().add(l4);
        group.getChildren().add(l5); 
        group.getChildren().add(l6);

    
    
    
    
      
    //Group root = new Group();  
    group.getChildren().addAll(rect1,rect2,rect3, rect4, rect5, rect6, rect7, rect8);  
    Scene scene = new Scene(group,1020,720);  
    primaryStage.setScene(scene);  
    primaryStage.setTitle("Rotation Example");  
    primaryStage.show();  
}  
public static void main(String[] args) {  
    launch(args);  
}  
}  