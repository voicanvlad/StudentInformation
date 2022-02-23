package GUI.Program;


public class Main {
    public static void main(String[] args) {
        int dimension=0;
        dimension=Integer.parseInt(args[0]);
        new GraphicalInterface(dimension);
    }
}

//C:\Users\acer\Desktop\GitHub> javac GUI/Program/Main.java
//C:\Users\acer\Desktop\GitHub> java GUI.Program.Main 6