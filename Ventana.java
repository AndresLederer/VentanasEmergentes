/*	VENTANA (JFrame)
 *	___________________________
 * |PANEL (JPanel)			   |
 * |						   |	
 * |  [ (JLabel) ]	    	   |
 * |						   |
 * |  [ (JLabel) ]	    	   |
 * |						   |
 * |___________________________|
 * 
 * La VENTANA es el cuadrilatero emergente en sí, sin un PANEL encima no tendria ningun complemento
 * 
 * El PANEL es el conjunto los componentes que se coloca sobre la VENTANA
 * 
 * Los JLabel son las ETIQUETAS (txt/img) que forman al PANEL ("complementos")
 * 
 * 
 * 
 */
package Ventana;

//librerias importadas
import java.awt.Color; //Lib para colores de bg y fg
import java.awt.Font; //Lib para definir fuente de JLabel de texto
import java.awt.Image;

import javax.swing.JFrame; //Lib para ventana emergente
import javax.swing.JPanel; //Lib para panel en ventana
import javax.swing.JLabel; //Lib para etiquetas en panel
import javax.swing.JButton; //Lib para botones
import javax.swing.JRadioButton; //Lib para radio botones

import javax.swing.SwingConstants; //Lib para posicionar el txt de las JLabel
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon; //Lib para usar img (JLabel)

public class Ventana extends JFrame {
	JPanel panel;
	
	//CREO Y DEFINO VENTANA
	public Ventana() {
		//define q al click en la [X] la ventana se cierra y termina la ejecucion del programa)
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//define el titulo de la ventana
		this.setTitle("ITS Photography");
		
		//define ubicacion inical de la ventana y tamaño (x,y,ancho,alto)
		//this.setBounds(1000,250,500,300);

		//define el tamaño de la ventana (ancho,alto)
		this.setSize(600,720);
		
		//define ubicacion inicial de la ventana (x,y)
		//this.setLocation(1000,250);
		
		//define la posicion relativa a un Componente. Si (null) => centra la ventana
		this.setLocationRelativeTo(null);
		
		//llamado al metodo q crea y pega el panel inicial en la ventana emergente
		componente();
		
	}
	
	//CREO PANEL Y DEFINO SUS COMPONENTES
	private void componente() {
		crearPanel();
		colocarEtiquetas();
		colocarBotones();
		colocarRadioBotones();
		
		//FINALLY, AGREGO EL PANEL EN LA VENTANA EMERGENTE
		this.getContentPane().add(panel); 
	}
	
	private void crearPanel() {
		//PANEL (JPanel)
		panel = new JPanel(); //inicio un panel JPanel
		panel.setBackground(Color.DARK_GRAY); //defino el color de fondo
		panel.setLayout(null); //desactivo el diseño por defecto del panel para poder mover los componentes libremente 
		//=> OBLIGADAMTE. DEBO DEFINIR UNA POSICION A CADA EQTIQUETA CON .setBounds(x,y,width,hight)

	}
	
	private void colocarEtiquetas() {
		//ETIQUETA DE TXT (JLabel)
		//JLabel etiquetaTxt1 = new JLabel(); //creo etiqueta de txt
		JLabel etiquetaTxt1 = new JLabel("My best memories in pictures",SwingConstants.CENTER);
		//etiquetaTxt1.setText("My best memories in pictures!"); //defino el txt de la etiqueta
		//etiquetaTxt1.setHorizontalAlignment(SwingConstants.CENTER); //defino la posicion del txt EN la ETIQUETA
		etiquetaTxt1.setBounds(150,20,300,30); //reposiciono etiquetaTxt1
		
		etiquetaTxt1.setFont(new Font ("arial",Font.BOLD,20));//defino fuente,estilo y tamaño del texto
		etiquetaTxt1.setForeground(Color.WHITE); //defino el color de las letras del texto
		etiquetaTxt1.setOpaque(true); //desactivo el layout x defecto de las etiquetas => puedo definir un bground color
		etiquetaTxt1.setBackground(Color.BLUE);//defino el color de fondo de la JLlabel
		
		
		///ETIQUETA IMG (JLabel)
		ImageIcon img = new ImageIcon("C:\\Users\\dobra\\eclipse-workspace\\VentanaEmergente\\src\\Ventana\\sunrise.jpg"); //creo un objeto q contiene la imagen en sí
		//JLabel etiqImg = new JLabel(new ImageIcon("sunrise.jpg")); //creo etiqueta de imagen
		JLabel etiqImg = new JLabel();
		etiqImg.setBounds(175,70,250,430); //defino el tamaño y la poscion de la etiqueta imagen -> (x,y,W,H)
		//etiqImg.setOpaque(true);
		//etiqImg.setBackground(Color.RED);
				
		etiqImg.setIcon(new ImageIcon(img.getImage().getScaledInstance(etiqImg.getWidth(),etiqImg.getHeight(),Image.SCALE_SMOOTH)));
		//1- defino la imagen q tendra la etiqueta => creo otro objeto ImageIcon y llamo al objeto anterior q define la ruta
		//2- al objeto q llamo, lo llamo pero en una instancia de tamaño a escala => defino width, height y la forma de escalado
		//3- Ahora la etiqueta y la imagen tendrán AMBAS el mismo tamaño => uso <etiqImg.setBounds(x,y,W,H)> para definir poscion y tamaños
				
		panel.add(etiquetaTxt1); //agrego etiqueta txt al panel
		panel.add(etiqImg); //agrego etiqueta img al panel
	}

	private void colocarBotones() {
//		BOTON (JButton)
		JButton btnLogIn = new JButton("Log In"); //instancio btn JButton con txt dentro
		btnLogIn.setBounds(155,520,120,30); //defino posicion y tamaño
		btnLogIn.setFont(new Font("arial",Font.PLAIN,15)); //defino font,style,size del txt
		btnLogIn.setForeground(Color.BLACK); //defino color del txt
		btnLogIn.setMnemonic('l'); //defino shortcut del btn (ALT+i)
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(325,520,120,30); 
		btnSignIn.setFont(new Font("arial",Font.PLAIN,15));
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setMnemonic('s');
		
		panel.add(btnLogIn); //agrego el boton al panel
		panel.add(btnSignIn);
	}
	
	private void colocarRadioBotones() {
		//RADIO BOTONES
		JRadioButton rbHombre = new JRadioButton("Hombre",false);
		JRadioButton rbMujer = new JRadioButton("Mujer",false);
		JRadioButton rbSinGenero = new JRadioButton("Prefiero no decirlo",false);
		
		//Agrupo RadioButtons
		ButtonGroup rbGroup = new ButtonGroup();
		rbGroup.add(rbHombre);
		rbGroup.add(rbMujer);
		rbGroup.add(rbSinGenero);

		//defino tipografia
		rbHombre.setFont(new Font("arial",Font.PLAIN,10));
		rbMujer.setFont(new Font("arial",Font.PLAIN,10));
		rbSinGenero.setFont(new Font("arial",Font.PLAIN,10));
		
		//defino color de fonde y color de la letra
		rbHombre.setOpaque(false);
		rbHombre.setForeground(Color.GREEN);
		rbMujer.setOpaque(false);
		rbMujer.setForeground(Color.GREEN);
		rbSinGenero.setOpaque(false);
		rbSinGenero.setForeground(Color.GREEN);
		
		//defino posicion de cada RadioButton
		rbHombre.setBounds(100,600,120,25);
		rbMujer.setBounds(240,600,120,25);
		rbSinGenero.setBounds(380,600,120,25);

		//agrego los RadioButtons al panel
		panel.add(rbHombre);
		panel.add(rbMujer);
		panel.add(rbSinGenero);
	}
}
















