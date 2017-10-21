/*
 * Title: Calculator.java
 * Author: Christian Martinez
 * Description: A simple calculator app that works with addition,
 * Subtraction, and sine functions.
 * Date: 11/4/2016
 */
package calculator;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application{
	private Button numButton0;
	private Button numButton1;
	private Button numButton2;
	private Button numButton3;
	private Button numButton4;
	private Button numButton5;
	private Button numButton6;
	private Button numButton7;
	private Button numButton8;
	private Button numButton9;
	private Button minus;
	private Button plus;
	private Button clear;
	private Button sine;
	private Button equal;
	private GridPane buttonNode;
	private BorderPane rootNode;
	private MenuBar mb;
	private Menu helpMenu;
	private MenuItem help;
	private TextField displayCalc;
	private Button negate;
	private Dialog helpDialog;
	private Scene newScene;
	
	public static void main(String[] args) {
		try{
			launch(args);
		}catch(RuntimeException e){
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage stage) throws Exception {
		rootNode = new BorderPane();
		buttonNode = new GridPane();
		buttonNode.setHgap(5);
		buttonNode.setVgap(5);
		createComponents();
		setButtonText();
		addButtonsToGridPane();
		setActionsToButtons();
		createMenuHelper();
		addToRootNode();
		newScene = new Scene(rootNode, 200, 200);
		stage.setScene(newScene);
		stage.show();
	}
	public void createMenuHelper(){
		 mb = new MenuBar();
		 helpMenu = new Menu("Help");
		 help = new MenuItem("Help");
		 help.setOnAction(ae -> openDialog());
		 helpMenu.getItems().addAll(help);
		 mb.getMenus().addAll(helpMenu);
	}
	public void addToRootNode(){
		rootNode.setBottom(mb);
		BorderPane.setAlignment(buttonNode, Pos.CENTER);
		rootNode.setCenter(buttonNode);
		BorderPane.setAlignment(displayCalc, Pos.TOP_CENTER);
		rootNode.setTop(displayCalc);
	}	
	public void createComponents(){
		numButton0 = new Button();
		numButton1 = new Button();
		numButton2 = new Button();
		numButton3 = new Button();
		numButton4 = new Button();
		numButton5 = new Button();
		numButton6 = new Button();
		numButton7 = new Button();
		numButton8 = new Button();
		numButton9 = new Button();
		negate = new Button();
		minus = new Button();
		clear = new Button();
		plus = new Button();
		sine = new Button();
		equal = new Button();
		displayCalc = new TextField();
		displayCalc.setEditable(false);
		displayCalc.setAlignment(Pos.TOP_RIGHT);
	}
	public void setButtonText(){
		numButton0.setText("0");
		numButton1.setText("1");
		numButton2.setText("2");
		numButton3.setText("3");
		numButton4.setText("4");
		numButton5.setText("5");
		numButton6.setText("6");
		numButton7.setText("7");
		numButton8.setText("8");
		numButton9.setText("9");
		minus.setText("-");
		plus.setText("+");
		equal.setText("=");
		sine.setText("sin");
		negate.setText("NEG");
		clear.setText("CLR");
	}
	public void addButtonsToGridPane(){
		buttonNode.add(numButton0, 0, 4);
		buttonNode.add(numButton1, 0, 3);
		buttonNode.add(numButton2, 1, 3);
		buttonNode.add(numButton3, 2, 3);
		buttonNode.add(numButton4, 0, 2);
		buttonNode.add(numButton5, 1, 2);
		buttonNode.add(numButton6, 2, 2);
		buttonNode.add(numButton7, 0, 1);
		buttonNode.add(numButton8, 1, 1);
		buttonNode.add(numButton9, 2, 1);
		buttonNode.add(clear, 1, 4);
		buttonNode.add(equal, 2, 4);
		buttonNode.add(minus, 3, 4);
		buttonNode.add(sine, 3, 1);
		buttonNode.add(plus, 3, 3);
		buttonNode.add(negate, 3, 2);
	}
	public void setActionsToButtons(){
		clear.setOnAction(ae -> displayCalc.setText(""));
		numButton0.setOnAction(ae -> displayCalc.appendText("0"));
		numButton1.setOnAction(ae -> displayCalc.appendText("1"));
		numButton2.setOnAction(ae -> displayCalc.appendText("2"));
		numButton3.setOnAction(ae -> displayCalc.appendText("3"));
		numButton4.setOnAction(ae -> displayCalc.appendText("4"));
		numButton5.setOnAction(ae -> displayCalc.appendText("5"));
		numButton6.setOnAction(ae -> displayCalc.appendText("6"));
		numButton7.setOnAction(ae -> displayCalc.appendText("7"));
		numButton8.setOnAction(ae -> displayCalc.appendText("8"));
		numButton9.setOnAction(ae -> displayCalc.appendText("9"));
		minus.setOnAction(ae -> displayCalc.appendText("-"));
		plus.setOnAction(ae -> displayCalc.appendText("+"));
		sine.setOnAction(ae -> sineFunction());
		negate.setOnAction(ae -> negateFunction());
		equal.setOnAction(ae -> equalFunction());
		
	}
	public void openDialog(){
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Help");
		alert.setHeaderText("Calculator.java basic Guide");
		alert.setContentText("Calculator.java - made by Christian Martinez \n This application adds, subtracts, and gives the values of a sine function.");
		alert.showAndWait();
		
	}
	public void sineFunction(){
		try{
			DecimalFormat df = new DecimalFormat("##.00");
			double val = Double.parseDouble(displayCalc.getText());
			double total = Math.sin(val);
			displayCalc.setText(df.format(total));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void negateFunction(){
		try{
			double val = Double.parseDouble(displayCalc.getText());
			double total = (-1 * val);
			String newTotal = Double.toString(total);
			displayCalc.setText(newTotal);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public void equalFunction(){
		try{
			String str = displayCalc.getText();
			if(str.contains("+")){
				double total = 0;
				String[] parts = str.split("\\+");
				for(int i = 0; i < parts.length; i++){
					double val = Double.parseDouble(parts[i]);
					total += val;
				}
				String newTotal = Double.toString(total);
				displayCalc.setText(newTotal);
			}
			if(str.contains("-")){
				String[] parts = str.split("\\-");
				double valueOne = Double.parseDouble(parts[0]);
				double valueTwo = Double.parseDouble(parts[1]);
				double total = valueOne - valueTwo;
				String newTotal = Double.toString(total);
				displayCalc.setText(newTotal);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}
}
