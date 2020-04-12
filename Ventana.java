package Ventana;

//librerias importadas
import java.awt.Color; //Lib para colores de bg y fg
import java.awt.Font; //Lib para definir fuente de JLabel de texto
import java.awt.Image;

import javax.swing.JFrame; //Lib para ventana emergente
import javax.swing.JPanel; //Lib para panel en ventana
import javax.swing.JLabel; //Lib para etiquetas en panel

import javax.swing.SwingConstants; //Lib para posicionar el txt de las JLabel
import javax.swing.ImageIcon; //Lib para usar img (JLabel)

public class Ventana extends JFrame {
	
	//CREO Y DEFINO VENTANA
	public Ventana() {
		//define q al click en la [X] la ventana se cierra y termina la ejecucion del programa)
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//define el titulo de la ventana
		this.setTitle("ITS Photography");
		
		//define ubicacion inical de la ventana y tamaño (x,y,ancho,alto)
		//this.setBounds(1000,250,500,300);

		//define el tamaño de la ventana (ancho,alto)
		this.setSize(1000,800);
		
		//define ubicacion inicial de la ventana (x,y)
		//this.setLocation(1000,250);
		
		//define la posicion relativa a un Componente. Si (null) => centra la ventana
		this.setLocationRelativeTo(null);
		
		//llamado al metodo q crea y pega el panel inicial en la ventana emergente
		componente();
		
	}
	
	//CREO PANEL Y DEFINO SUS COMPONENTES
	private void componente() {
		//PANEL (JPanel)
		JPanel panel = new JPanel(); //inicio un panel JPanel
		panel.setBackground(Color.DARK_GRAY); //defino el color de fondo
		panel.setLayout(null); //desactivo el diseño por defecto del panel para poder mover los componentes libremente => OBLIGADAMTE. DEBO DEFINIR UNA POSICION DE LA EQTIQUETA CON .SETLABEL(x,y,width,hight)
		
		
		
		//ETIQUETA DE TXT (JLabel)
		//JLabel etiquetaTxt1 = new JLabel(); //creo etiqueta de txt
		JLabel etiquetaTxt1 = new JLabel("My best memories in pictures",SwingConstants.CENTER);
		//etiquetaTxt1.setText("My best memories in pictures!"); //defino el txt de la etiqueta
		//etiquetaTxt1.setHorizontalAlignment(SwingConstants.CENTER); //defino la posicion del txt EN la ETIQUETA
		etiquetaTxt1.setBounds(300,10,400,30); //reposiciono etiquetaTxt1
		
		etiquetaTxt1.setFont(new Font ("arial",Font.BOLD,20));//defino fuente,estilo y tamaño del texto
		etiquetaTxt1.setForeground(Color.WHITE); //defino el color de las letras del texto
		etiquetaTxt1.setOpaque(true); //desactivo el layout x defecto de las etiquetas => puedo definir un bground color
		etiquetaTxt1.setBackground(Color.BLUE);//defino el color de fondo de la JLlabel
		
		
		///ETIQUETA IMG
		ImageIcon img = new ImageIcon("C:\\Users\\dobra\\eclipse-workspace\\VentanaEmergente\\src\\Ventana\\sunrise.jpg"); //creo un objeto q contiene la imagen en sí
		//JLabel etiqImg = new JLabel(new ImageIcon("sunrise.jpg")); //creo etiqueta de imagen
		JLabel etiqImg = new JLabel();
		etiqImg.setBounds(350,70,300,500); //defino el tamaño y la poscion de la etiqueta imagen -> (x,y,W,H)
		//etiqImg.setOpaque(true);
		//etiqImg.setBackground(Color.RED);
		
		etiqImg.setIcon(new ImageIcon(img.getImage().getScaledInstance(etiqImg.getWidth(),etiqImg.getHeight(),Image.SCALE_SMOOTH)));
		//1- defino la imagen q tendra la etiqueta => creo otro objeto ImageIcon y llamo al objeto anterior q define la ruta
		//2- al objeto q llamo, lo llamo pero en una instancia de tamaño a escala => defino width, height y la forma de escalado
		//3- Ahora la etiqueta y la imagen tendrán AMBAS el mismo tamaño => uso <etiqImg.setBounds(x,y,W,H)> para definir poscion y tamaños
		
		panel.add(etiquetaTxt1); //agrego componentes al panel
		panel.add(etiqImg);
		
		//FINALLY, AGREGO EL PANEL EN LA VENTANA EMERGENTE
		this.getContentPane().add(panel); 
	}
}
















