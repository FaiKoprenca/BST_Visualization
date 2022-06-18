package PROJECT;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(); // Create a tree

        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-background-color: #000000");
        BTView btView = new BTView(tree);// Create a View
        BTView traversalView=new BTView();

        pane.setTop(btView);
        pane.setLeft(traversalView);
        pane.setPadding(new Insets(20,0,100,0));


        TextField tfKey = new TextField();
        tfKey.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);

        Button btInsert = new Button("Insert");
        btInsert.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btDelete = new Button("Delete");
        btDelete.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btInorder= new Button("Inorder");
        btInorder.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btPreorder=new Button("Preorder");
        btPreorder.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btPostorder=new Button("Postorder");
        btPostorder.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btHeight = new Button("Height");
        btHeight.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btMax = new Button("Max Node");
        btMax.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btMin = new Button("Min Node");
        btMin.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btClear = new Button("Clear Tree");
        btClear.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");
        Button btSize = new Button("Size");
        btSize.setStyle("-fx-background-color: #32CD32;-fx-font-weight: bold;");

        HBox hBox = new HBox(5);
        Label label=new Label("Enter a key: ");
        label.setStyle("-fx-text-fill: #32CD32;-fx-font-weight: bold;");
        hBox.getChildren().addAll(label, tfKey, btInsert, btDelete,btInorder,btPreorder,btPostorder,btHeight,btMax,btMin,btSize,btClear);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);



        btInsert.setOnAction(e -> {
            traversalView.getChildren().clear();
            int key = Integer.parseInt(tfKey.getText());
            if (tree.search(key)) { // key is in the tree already
                btView.displayTree();
                btView.setStatus(key + " is already in the tree");
            } else {
                tree.insert(key); // Insert a new key
                btView.displayTree();
                btView.setStatus(key + " is inserted in the tree");
            }
        });



        btDelete.setOnAction(e -> {
            traversalView.getChildren().clear();
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) { // key is not in the tree
                btView.displayTree();
                btView.setStatus(key + " is not in the tree");
            } else {
                tree.delete(key); // Delete a key
                btView.displayTree();
                btView.setStatus(key + " is deleted from the tree");
            }
        });


        btInorder.setOnAction(e -> {

            //Display Inorder Traversal

            traversalView.displayTraversal("Inorder : ",tree.inorder());
            //traversalView.setStatus("This is Inorder traversal");


        });

        btPostorder.setOnAction(e -> {

            //Display Postorder Traversal
            traversalView.displayTraversal("Postorder : ",tree.postorder());
            //traversalView.setStatus("This is Postorder traversal");



        });

        btPreorder.setOnAction(e -> {

            //Display Preorder Traversal

            traversalView.displayTraversal("Preorder : ",tree.preorder());
            //traversalView.setStatus("This is Preorder traversal");

        });


        btHeight.setOnAction(e -> {

            //Display Height of the tree
            traversalView.getChildren().clear();
            traversalView.setStatus("The height of the tree is "+tree.height());

        });


        btMax.setOnAction(e -> {

            //Display Max Node
            traversalView.getChildren().clear();
            traversalView.setStatus("Max node is "+tree.getMax(tree.getRoot()));




        });

        btMin.setOnAction(e -> {

            //Display Max Node
            traversalView.getChildren().clear();
            traversalView.setStatus("Min node is "+tree.getMin(tree.getRoot()));

        });
        btSize.setOnAction(e -> {

            traversalView.getChildren().clear();
            traversalView.setStatus("Size of the tree is "+tree.getSize());


        });


        btClear.setOnAction(e -> {
            btView.getChildren().clear();
            traversalView.getChildren().clear();
            btView.setStatus("Tree is Empty");
            tree.clear();
        });

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 450, 250);
        primaryStage.setTitle("BSTAnimation");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        ;
    }
}




