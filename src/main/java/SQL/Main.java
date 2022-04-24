/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SQL;

/**
 *
 * @author Giovanny Vargas
 */
public class Main {
    /*private static JLabel usuarioLabel;
    private static JTextField usuarioText;
    private static JLabel contraseniaLabel;
    private static JPasswordField contraseniaText;
    private static JButton boton;
    //private static JLabel exito;*/

    public static void main(String[] args) {

        //Conexion objetoconexion = new Conexion();  //Genera la conexión a la BD Local
        //objetoconexion.establecerConexion();

        /*JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        frame.setSize(400,250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel); //Agregamos panel (donde iran las cosas) al frame

        panel.setLayout(null);

        /*usuarioLabel = new JLabel("Usuario"); //Asignamos un label (Puedes relacionarlo a TS, siendo label parecido)
        usuarioLabel.setBounds(10,20,80,25);  //Asignamos la posicion (Puedes relacionarlo a CSS) Siendo el orden Horizontalidad, Verticalidad, y lo siguiente es lo mismo pero para el placeHolder
        panel.add(usuarioLabel);// Se agrega al panel 

        usuarioText = new JTextField(20); //La entrada de texto, donde escribira el usuario, por eso el nombre de la variable, adentro del constructor ponemos lo largo de ese texto
        usuarioText.setBounds(100,20,165,25); //Mismsa indicaciones para el setBounds
        panel.add(usuarioText); //Se añade la entrada de texto (Donde se entrara, no ningun valor hasta ahora)

        contraseniaLabel = new JLabel("Contraseña"); //Mismo procedimiento anterior pero para la contraseña
        contraseniaLabel.setBounds(10,50,80,25);
        panel.add(contraseniaLabel);

        contraseniaText = new JPasswordField(); //Aqui cambie de TextField a PasswordField siendo Password field la tipica que pone asteriscos como manera de 
        //encriptar la contraseña asi nadie mas puede ve rlo que el usuario esta escribiendo (Hablando del mundo fisico)
        contraseniaText.setBounds(100,50,165,25);
        panel.add(contraseniaText);
        
        boton = new JButton("Ingresar"); //Creamos un boton, que dentro ponemos que diga Ingresar
        boton.setBounds(10,80,80,25); //Lo mismo de siempre
        boton.addActionListener(new Main()); //Añadimos un actionListener, que abajo tenemos su metodo
        panel.add(boton); //Añadimos al panel

        /*exito = new Jlabel();
        exito.setBounds(10,100,80,25);
        panel.add(exito)*/

        //frame.setVisible(true);
        
    }

    //@Override 
    // void actionPerformed(ActionEvent arg0) {
        //System.out.println("Clickeaste el boton!"); //Verificación en la consola que todo funciona correcto
        //Antes de crear el JFRAME
        /*String usuario = usuarioText.getText(); //Obtiene los "valores" tanto del usuario como contraseña, esto es como un ngmodel
        String contrasenia = contraseniaText.getText(); //Aparece en amarillo getText de contrasenia porque "It's not longer supported by Java, something like that, doesn't affect our proyect"
        Conexion con = new Conexion();
        con.establecerConexion(usuario,contrasenia);*/

        //System.out.println("Usuario:"+usuario+ "\nContraseña:" + contrasenia); //Verificacion utilizada para saber si la funcionalidad de credenciales fue correcta

        //Login utilizado previamente, lo dejo como evidencia si lo necesito para un futuro
        /*if(usuario.equals("usersql") && contrasenia.equals("root2")){ //Basicamente si el usuario y contraseña es igual ,procede a la conexion
        Conexion.bandera = !(Conexion.bandera); //WIP Es para que solo sea la entrada y no se hagan consultas ni nada por ahora, WORK IN PROGRESS
        Conexion objetoconexion = new Conexion();  //Genera la conexión a la BD Local
        objetoconexion.establecerConexion();
        }
        else{ //De no ser las credenciales correctas, nos suelta un mensaje en una ventanita
            JOptionPane.showMessageDialog(null,"Credenciales incorrectas, intentar de nuevo"); */
        //}//
        
    //}
}
