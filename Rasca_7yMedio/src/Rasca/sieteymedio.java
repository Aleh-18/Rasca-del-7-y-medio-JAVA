package Rasca;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class sieteymedio {
	JFrame jfrVentana = null;
	
	JPanel jpnPrincipal = null;
	
	JLabel jlblogo = null;
	JLabel jlbjaviuwu = null;
	JLabel jlbtitulo = null;
	
	JLabel jlbtextobanca = null;
	JLabel jlbtextobonus = null;
	JLabel jlbtextocartas = null;
	
	
	JPanel jpnJuego = null;
	
	 JButton jbtBanca1 = null;
	 JLabel  jlbBanca1 = null;
	 JButton jbtBanca2 = null;
	 JLabel  jlbBanca2 = null;
	
	JButton jbtNumeroBonus = null;
	JLabel	jlbNumeroBonus = null;
	JButton jbtResultadoBonus = null;
	JLabel  jlbResultadoBonus = null;
	
	JButton jbtCarta1 = null;
    JLabel  jlbCarta1 = null;
    JButton jbtCarta2 = null;
    JLabel  jlbCarta2 = null;
    JButton jbtCarta3 = null;
    JLabel  jlbCarta3 = null;
    
    JButton jbtPremio = null;
    JLabel  jlbPremio = null;
    
    JFrame jfrResultado = null;
    JPanel jpnResultado = null;
    JLabel jlbResultado = null;
    JButton jbtComprobar = null; 
    
    Clip Musicoteguapo;
    
    JButton jbtCarton = null;
    
    
    // Variables para almacenar las puntuaciones
   	double SB = 0; // Suma de la banca
   	double SC = 0; // Suma del jugador
   	int bonus = 0; // Carta bonus
	
   	int[] cartasBanca = new int[2]; // Dos cartas para la banca
   	int[] cartasJugador = new int[3]; // Tres cartas para el jugador
   	
   	int[] valoresPremio = {1, 2, 4, 10, 15, 30, 75, 150, 750, 1000};
   	int[] valoresBonus = {300, 500, 7500}; 
   	
   	int resultadoBonus = 0; 

	public sieteymedio() {
		//Ventana
		jfrVentana = new JFrame("RASCA DEL JAVI Y MEDIO");
		jfrVentana.setSize(600, 400);
		jfrVentana.setLocationRelativeTo(null);
		jfrVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Panel Principal
		jpnPrincipal = new JPanel(){
		    @Override
		    protected void paintComponent(Graphics g) {
		        super.paintComponent(g);

		        // Pintar la primera imagen
		        ImageIcon background1 = new ImageIcon(getClass().getResource("betis.png"));
		        g.drawImage(background1.getImage(), 0, 0, getWidth(), getHeight(), this);
		        
		        // Pintar la segunda imagen encima
		        ImageIcon background2 = new ImageIcon(getClass().getResource("sparkles.png"));
		        g.drawImage(background2.getImage(), 50, 50, getWidth() - 100, getHeight() - 100, this);
		    }
		};
		jpnPrincipal.setLayout(null);
		jfrVentana.add(jpnPrincipal);
		
		
		//Decoracion para panel principal
		  //Logo de la ONCE
			ImageIcon logo = new ImageIcon(getClass().getResource("oncelogo.png")); // Cargar la imagen original
			Image scaledLogo = logo.getImage().getScaledInstance(130, 60, Image.SCALE_SMOOTH); // Redimensionar
			JLabel jlblogo = new JLabel(new ImageIcon(scaledLogo));
			jlblogo.setBounds(0, 0, 130, 60); // Ajustar tamaño y posición
			jpnPrincipal.add(jlblogo);
		  //Careto de Javi
			 ImageIcon javiuwu = new ImageIcon(getClass().getResource("javi.png")); 
		     Image scaledjaviuwu = javiuwu.getImage().getScaledInstance(175, 210, Image.SCALE_SMOOTH);
		     JLabel jlbjaviuwu = new JLabel(new ImageIcon(scaledjaviuwu));
		     jlbjaviuwu.setBounds(10, 150, 175, 210);
		     jpnPrincipal.add(jlbjaviuwu);
		   //Titulo
		     	ImageIcon titulo = new ImageIcon(getClass().getResource("titulo.png"));
		     	Image scaledtitulo = titulo.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
		     	JLabel jlbtitulo = new JLabel(new ImageIcon(scaledtitulo));
		     	jlbtitulo.setBounds(10,28, 150, 100);
		     	jpnPrincipal.add(jlbtitulo);
		   //TextoBanca
		     	ImageIcon textobanca = new ImageIcon(getClass().getResource("banca.png"));
		     	Image scaledtextobanca = textobanca.getImage().getScaledInstance(30, 130, Image.SCALE_SMOOTH);
		     	JLabel jlbtextobanca = new JLabel(new ImageIcon(scaledtextobanca));
		     	jlbtextobanca.setBounds(225,50, 30, 130);
		     	jlbtextobanca.setVisible(true);
		     	jpnPrincipal.add(jlbtextobanca);
		   //TextoBonus
		     	ImageIcon textobonus = new ImageIcon(getClass().getResource("bonus.png"));
		     	Image scaledtextobonus = textobonus.getImage().getScaledInstance(30, 130, Image.SCALE_SMOOTH);
		     	JLabel jlbtextobonus = new JLabel(new ImageIcon(scaledtextobonus));
		     	jlbtextobonus.setBounds(450,50, 30, 130);
		     	jlbtextobonus.setVisible(true);
		     	jpnPrincipal.add(jlbtextobonus);
		   //TextoBonus
		     	ImageIcon textocartas = new ImageIcon(getClass().getResource("cartas.png"));
		     	Image scaledtextocartas = textocartas.getImage().getScaledInstance(30, 130, Image.SCALE_SMOOTH);
		     	JLabel jlbtextocartas = new JLabel(new ImageIcon(scaledtextocartas));
		     	jlbtextocartas.setBounds(210,180, 60, 130);
		     	jlbtextocartas.setVisible(true);
		     	jpnPrincipal.add(jlbtextocartas);

		     	
		     	
		 //Panel de juego    
		 jpnJuego = new JPanel(){
			    @Override
			    protected void paintComponent(Graphics g) {
			        super.paintComponent(g);

			        // Pintar la primera imagen
			        ImageIcon fondojogo = new ImageIcon(getClass().getResource("fondojuego.png"));
			        g.drawImage(fondojogo.getImage(), 0, 0, getWidth(), getHeight(), this);

			    }
			};
		 jpnJuego.setBounds(200, 60, 900, 1500);
		 jpnJuego.setLayout(null);
	     jpnPrincipal.add(jpnJuego);
		 
	     
	     //Cartas
	     	//Imagen Cartas
	     		ImageIcon card = new ImageIcon(getClass().getResource("card.png"));
	     		Image img = card.getImage(); // Obtener la imagen
	     		Image scaledcard = img.getScaledInstance(80, 100, Image.SCALE_SMOOTH);
	     		card = new ImageIcon(scaledcard);
		     	//Imagen Carta Numero Bonus
	     		ImageIcon bonusnumbercard = new ImageIcon(getClass().getResource("bonusnumbercard.png"));
	     		Image imgbonusnumbercard = bonusnumbercard.getImage(); // Obtener la imagen
	     		Image scaledbonusnumbercard = imgbonusnumbercard.getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	     		bonusnumbercard = new ImageIcon(scaledbonusnumbercard);
	     		//Imagen Carta Resultado Bonus
	     		ImageIcon bonusresultcard = new ImageIcon(getClass().getResource("bonusresultcard.png"));
	     		Image imgbonusresultcard = bonusresultcard.getImage(); // Obtener la imagen
	     		Image scaledbonusresultcard = imgbonusresultcard.getScaledInstance(80, 50, Image.SCALE_SMOOTH); 
	     		bonusresultcard = new ImageIcon(scaledbonusresultcard);
	     		// Carta 1 (Banca)
	     		JButton jbtBanca1 = new JButton(card);
	     		jbtBanca1.setBounds(50, 5, 80, 100);
	     		jpnJuego.add(jbtBanca1);
	     		// Carta 2 (Banca)
	     		JButton jbtBanca2 = new JButton(card);
	     		jbtBanca2.setBounds(135, 5, 80, 100);
	     		jpnJuego.add(jbtBanca2);

	     		// Carta 3 (Carta Numero Bonus)
	     		JButton jbtNumeroBonus = new JButton(bonusnumbercard);
	     		jbtNumeroBonus.setBounds(275, 5, 80, 50);
	     		jpnJuego.add(jbtNumeroBonus);
	     		// Carta 3 (Carta Resultado Bonus)
	     		JButton jbtResultadoBonus = new JButton(bonusresultcard);
	     		jbtResultadoBonus.setBounds(275, 50, 80, 50); 
	     		jpnJuego.add(jbtResultadoBonus);
	     		
	     		// Carta 4 (JCarta1)
	     		JButton jbtCarta1 = new JButton(card);
	     		jbtCarta1.setBounds(60, 130, 80, 100); 
	     		jpnJuego.add(jbtCarta1);
	     		// Carta 5 (JCarta2)
	     		JButton jbtCarta2 = new JButton(card);
	     		jbtCarta2.setBounds(160, 130, 80, 100); 
	     		jpnJuego.add(jbtCarta2);
	     		// Carta 6 (JCarta3)
	     		JButton jbtCarta3 = new JButton(card);
	     		jbtCarta3.setBounds(260, 130, 80, 100); 
	     		jpnJuego.add(jbtCarta3);
	     
	     //DINERINHO
	     	//Premio Visual
	     		jbtPremio = new JButton();
	     		jbtPremio.setBounds(80, 250, 250, 40);
	     		ImageIcon premioIcon = new ImageIcon(getClass().getResource("premio.png"));
	     		Image premioImage = premioIcon.getImage();
	     		Image scaledPremioImage = premioImage.getScaledInstance(250, 40, Image.SCALE_SMOOTH);
	     		ImageIcon scaledPremioIcon = new ImageIcon(scaledPremioImage);
	     		jbtPremio.setIcon(scaledPremioIcon);
	     		jbtPremio.setOpaque(false);
	     		jbtPremio.setContentAreaFilled(false);
	     		jbtPremio.setBorderPainted(false);
	     		jpnJuego.add(jbtPremio);
		        
		        jlbPremio = new JLabel("", JLabel.CENTER);
		        jlbPremio.setBounds(jbtPremio.getBounds()); 
		        jlbPremio.setFont(jlbPremio.getFont().deriveFont(30f)); // Fuente grande
		        jlbPremio.setForeground(java.awt.Color.YELLOW); // Color del texto
		        jlbPremio.setVisible(false); // Inicia oculto
		        jpnJuego.add(jlbPremio);
		      //Premio Funcion
		        jbtPremio.addActionListener(e -> {
		            if (jbtPremio.isEnabled()) {
		                int premio = generarPremio(); // Genera el premio
		                jbtPremio.setEnabled(false); // Desactiva el botón
		                jlbPremio.setText(String.valueOf(premio+ " €"));
		                jlbPremio.setVisible(true); 
		            }
		            });
		        jpnJuego.add(jbtPremio);

	     	//Funciones BANCA
		        // Número de la carta (Banca1)
		        jlbBanca1 = new JLabel("", JLabel.CENTER);
		        jlbBanca1.setBounds(50, 5, 80, 100); 
		        jlbBanca1.setFont(jlbBanca1.getFont().deriveFont(30f)); 
		        jlbBanca1.setForeground(java.awt.Color.RED); 
		        jlbBanca1.setOpaque(false); 
		        jlbBanca1.setVisible(false); 
		        jbtBanca1.add(jlbBanca1);
		        // Acción del botón (Banca1)
		        jbtBanca1.addActionListener(e -> {
		            if (!jlbBanca1.isVisible()) { 
		                int valor = generarNumeroCarta();
		                // Almacenar la carta en el array de la banca
		                cartasBanca[0] = valor; // Carta 1 de la banca
		                // Verificar que no se exceda el límite de 7.5
		                while (SB + calcularPuntaje(valor) > 7.5) {
		                    valor = generarNumeroCarta();
		                }
		                actualizarLabel(jlbBanca1, valor);
		                actualizarSumaBanca(valor);
		                jbtBanca1.setEnabled(false); 
		            }
		        });
		        // Número de la carta (Banca2)
		        jlbBanca2 = new JLabel("", JLabel.CENTER);
		        jlbBanca2.setBounds(135, 5, 80, 100); 
		        jlbBanca2.setFont(jlbBanca2.getFont().deriveFont(30f)); 
		        jlbBanca2.setForeground(java.awt.Color.RED); 
		        jlbBanca2.setOpaque(false); 
		        jlbBanca2.setVisible(false); 
		        jbtBanca2.add(jlbBanca2);
		        // Acción del botón (Banca2)
		        jbtBanca2.addActionListener(e -> {
		            if (!jlbBanca2.isVisible()) { 
		                int valor = generarNumeroCarta(); // Generar el número
		                // Almacenar la carta en el array de la banca
		                cartasBanca[1] = valor; // Carta 2 de la banca
		                // Verificar que no se exceda el límite de 7.5
		                while (SB + calcularPuntaje(valor) > 7.5) { 
		                    valor = generarNumeroCarta(); 
		                }
		                actualizarLabel(jlbBanca2, valor); 
		                actualizarSumaBanca(valor); 
		                jbtBanca2.setEnabled(false); 
		            }
		        });
		     
		        
			//Funciones Carta Bonus
		     // Número de la carta (Bonus)
		        jlbNumeroBonus = new JLabel("", JLabel.CENTER);
		        jlbNumeroBonus.setBounds(275, 5, 80, 100); 
		        jlbNumeroBonus.setFont(jlbNumeroBonus.getFont().deriveFont(30f)); 
		        jlbNumeroBonus.setForeground(java.awt.Color.MAGENTA); 
		        jlbNumeroBonus.setOpaque(false); 
		        jlbNumeroBonus.setVisible(false); 
		        jbtNumeroBonus.add(jlbNumeroBonus);
		        jbtNumeroBonus.addActionListener(e -> {
		            if (!jlbNumeroBonus.isVisible()) {
		                int valorBonus = generarNumeroBonus();
		                bonus = valorBonus;
		                actualizarBonus(valorBonus); 
		                jbtNumeroBonus.setEnabled(false);
		            }
		        });
		      // Resultado de la carta (Bonus)
		        jlbResultadoBonus = new JLabel("", JLabel.CENTER); 
		        jlbResultadoBonus.setBounds(275, 50, 80, 50); 
		        jlbResultadoBonus.setFont(jlbResultadoBonus.getFont().deriveFont(15f)); 
		        jlbResultadoBonus.setForeground(java.awt.Color.GREEN); 
		        jlbNumeroBonus.setOpaque(false); 
		        jlbNumeroBonus.setVisible(false); 
		        jbtResultadoBonus.add(jlbResultadoBonus);
		        jbtResultadoBonus.addActionListener(e -> {
		            int resultadoBonus = valoresBonus[(int) (Math.random() * valoresBonus.length)];
		            jlbResultadoBonus.setText(resultadoBonus + " €"); 
		            jbtResultadoBonus.setEnabled(false); 
		        });
		        
		        
		        
		        
		    //Funciones Cartas jugador
		        // Número de la carta (JCarta1)
		        jlbCarta1 = new JLabel("", JLabel.CENTER);
		        jlbCarta1.setBounds(60, 130, 80, 100);
		        jlbCarta1.setFont(jlbCarta1.getFont().deriveFont(30f));
		        jlbCarta1.setForeground(java.awt.Color.BLUE);
		        jlbCarta1.setOpaque(false);
		        jlbCarta1.setVisible(false);
		        jbtCarta1.add(jlbCarta1);
		        // Acción del botón (JCarta1)
		        jbtCarta1.addActionListener(e -> {
		            if (!jlbCarta1.isVisible()) {
		                int valor = generarNumeroCarta(); 
		                // Almacenar la carta en el array del jugador
		                cartasJugador[0] = valor; // Carta 1 del jugador
		                actualizarLabel(jlbCarta1, valor); // Actualizar el JLabel
		                actualizarSumaJugador(valor);
		                jbtCarta1.setEnabled(false);
		            }
		        });
		        // Número de la carta (JCarta2)
		        jlbCarta2 = new JLabel("", JLabel.CENTER);
		        jlbCarta2.setBounds(160, 130, 80, 100);
		        jlbCarta2.setFont(jlbCarta2.getFont().deriveFont(30f));
		        jlbCarta2.setForeground(java.awt.Color.BLUE);
		        jlbCarta2.setOpaque(false);
		        jlbCarta2.setVisible(false);
		        jbtCarta2.add(jlbCarta2);
		        // Acción del botón (JCarta2)
		        jbtCarta2.addActionListener(e -> {
		            if (!jlbCarta2.isVisible()) {
		                int valor = generarNumeroCarta(); // Generar el número
		                // Almacenar la carta en el array del jugador
		                cartasJugador[1] = valor; // Carta 2 del jugador
		                actualizarLabel(jlbCarta2, valor); // Actualizar el JLabel
		                actualizarSumaJugador(valor);
		                jbtCarta2.setEnabled(false);
		            }
		        });
		        // Número de la carta (JCarta3)
		        jlbCarta3 = new JLabel("", JLabel.CENTER);
		        jlbCarta3.setBounds(260, 130, 80, 100);
		        jlbCarta3.setFont(jlbCarta3.getFont().deriveFont(30f));
		        jlbCarta3.setForeground(java.awt.Color.BLUE);
		        jlbCarta3.setOpaque(false);
		        jlbCarta3.setVisible(false);
		        jbtCarta3.add(jlbCarta3);
		        // Acción del botón (JCarta3)
		        jbtCarta3.addActionListener(e -> {
		            if (!jlbCarta3.isVisible()) {
		                int valor = generarNumeroCarta(); // Generar el número
		                // Almacenar la carta en el array del jugador
		                cartasJugador[2] = valor; // Carta 3 del jugador
		                actualizarLabel(jlbCarta3, valor); // Actualizar el JLabel
		                actualizarSumaJugador(valor);
		                jbtCarta3.setEnabled(false);
		            }
		        });
		        
		        
		   
		       //BOTON COMPROBAR
		        jbtComprobar = new JButton("Comprobar");
		        jbtComprobar.setBounds(10, 120, 175, 30); //(justo encima de la imagen de Javi)
		        jpnPrincipal.add(jbtComprobar);
		        jbtComprobar.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                comprobarResultado(); 
		            }
		        });
		        
		        try { 
		            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("Ludopatia.wav"));
		            Musicoteguapo = AudioSystem.getClip(); 
		            Musicoteguapo.open(audioInputStream); 
		            Musicoteguapo.loop(Clip.LOOP_CONTINUOUSLY); 
		            System.out.println("Música cargada correctamente.");
		        } catch (Exception ex) { 
		            System.out.println("Error al reproducir el sonido."); 
		            ex.printStackTrace(); 
		        }
		       
		       //Boton cerrar
			   //Este boton era pa resetear pero no va solo cierra el programa y me he cansado de arreglarlo
		        jbtCarton = new JButton("Cerrar"); 
		        jbtCarton.setBounds(150, 10, 175, 30);
		        jpnPrincipal.add(jbtCarton);
		        jbtCarton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                try {
		                    // Obtén el ejecutable de Java
		                    String javaBin = System.getProperty("java.home") + "/bin/java";

		                    // Especifica manualmente el nombre completo de la clase principal
		                    String classpath = System.getProperty("java.class.path");
		                    String className = "sieteymedio.java"; // Reemplaza con tu clase principal

		                    // Construye el comando para reiniciar el programa
		                    ProcessBuilder builder = new ProcessBuilder(
		                        javaBin, "-cp", classpath, className
		                    );

		                    // Imprime el comando para depuración
		                    System.out.println("Ejecutando: " + builder.command());

		                    // Inicia el nuevo proceso
		                    builder.start();

		                    // Cierra la aplicación actual
		                    System.exit(0);
		                } catch (Exception ex) {
		                    ex.printStackTrace();
		                }
		            }
		        });





		       



				
				
		            
		        
		        
		//VISIBLE SI O VISIBLE NO
		jfrVentana.setVisible(true);
		 // Deshabilitar redimensionado
        jfrVentana.setResizable(false); 
	
	}
	
	// Métodos
    
	 private int generarNumeroCarta() {
	        return (int) (Math.random() * 8) + 1; // Generar número entre 1 y 8
	    }

	 private double calcularPuntaje(int numero) {
		    if (numero == 8) {
		        return 0.5; // Si el número es 8, devuelve 0.5 para la banca
		    } else {
		        return numero; // Para otros valores, devuelve el número tal cual
		    }
		}

		private void actualizarLabel(JLabel label, int valor) {
		    String valorFormateado;
		    if (valor == 8) {
		        valorFormateado = "0,5"; // Mostrar 0,5 si el valor es 8
		    } else {
		        valorFormateado = String.format("%d", valor); // Mostrar el número tal cual para otros valores
		    }
		    label.setText(valorFormateado); 
		    label.setVisible(true); 
		}

		private void actualizarSumaBanca(int valor) {
		    SB += calcularPuntaje(valor); // Sumar el puntaje calculado (0.5 si es 8, el número si no)
		    System.out.println("Suma de la banca: " + SB); // Imprimir para ver la suma de la banca
		}

		private void actualizarSumaJugador(int valor) {
		    SC += calcularPuntaje(valor); // Sumar el puntaje calculado (0.5 si es 8, el número si no)
		    System.out.println("Suma del jugador: " + SC); // Imprimir para ver la suma del jugador
		}
        
        
		// Función para generar un número aleatorio entre 1 y 7
		public int generarNumeroBonus() {
		    return (int) (Math.random() * 7) + 1; // Número entre 1 y 7
		}

		// Función para actualizar el valor de la carta bonus en la interfaz
		public void actualizarBonus(int valor) {
		    bonus = valor; // Guardar el valor generado en la variable bonus
		    jlbNumeroBonus.setText(String.valueOf(valor)); // Mostrar el número en la etiqueta
		    jlbNumeroBonus.setVisible(true); // Hacer visible la etiqueta
		}
		
		private int generarPremio() {
		    int indice = (int) (Math.random() * valoresPremio.length); // Selecciona un índice aleatorio
		    return valoresPremio[indice]; // Devuelve el valor correspondiente
		}


		
		//LOGICA JUEGO

		public void comprobarResultado() {
		    String mensaje = "No has ganado premio";
		   
		    boolean haGanadoBonus = false;
		    
		    for (int i = 0; i <= 2; i++) {  
		        if (cartasJugador[i] == bonus) {  
		            haGanadoBonus = true;
		            break;
		        }
		    
		    }
		    
		    if (SC > SB && SC <= 7.5) {
		        mensaje = "¡Has ganado el premio principal"; 

		        // Si la suma de cartas del jugador es exactamente 7.5, aplicar el x2
		        if (SC == 7.5) {
		            mensaje = "¡Has ganado el premio principal x2!";  // Premio principal con bonus
		        }

		        if (haGanadoBonus == true) {
		            mensaje += " ¡Has ganado el bonus!";
		        }
		    }
	  
		    if (haGanadoBonus == true) {
		        mensaje += "<br><br><br>¡Has ganado el bonus!";  
		    }

		    // Mostrar el mensaje en consola
		    System.out.println(mensaje);

		    // Crear una ventana emergente 
		    jfrResultado = new JFrame("Resultado");
		    jfrResultado.setSize(300, 200);  
		     jpnResultado = new JPanel();
		    jlbResultado = new JLabel("<html>" + mensaje + "</html>");
		    jpnResultado.add(jlbResultado);

		    jfrResultado.add(jpnResultado);  
		    jfrResultado.setVisible(true);
		}




	

		
		

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new sieteymedio();
	}

}
