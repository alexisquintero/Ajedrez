package presentacion;

import java.awt.EventQueue;



import javax.swing.JFrame;

import negocio.ControladorAjedrez;
import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {
	
	private int estado = 0; //Indica el estado del sistema respecto a los clicks, ninguno == 0, 1ro == 1, 2do == 2
							//El primer click indica la posición de inicio, el segundo click indica la posición de destino
	
	private ControladorAjedrez ca = new ControladorAjedrez();
	
	private StringBuilder desde = new StringBuilder();
	private StringBuilder hasta = new StringBuilder();

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 612, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,left][grow,right]", "[30.00,top][60.00,top][59.00,grow,center][60.00,bottom][30.00,bottom]"));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 0 1 5,grow");
		panel.setLayout(new GridLayout(0, 8, 0, 0));
		
		JButton btnA8 = new JButton("a8");
		btnA8.setActionCommand("A8");
		btnA8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA8.setForeground(new Color(255, 255, 255));
		btnA8.setBackground(new Color(204, 153, 51));
		panel.add(btnA8);
		
		JButton btnB8 = new JButton("b8");
		btnB8.setActionCommand("B8");
		btnB8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB8.setForeground(new Color(255, 255, 255));
		btnB8.setBackground(new Color(102, 51, 0));
		panel.add(btnB8);
		
		JButton btnC8 = new JButton("c8");
		btnC8.setActionCommand("C8");
		btnC8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC8.setForeground(new Color(255, 255, 255));
		btnC8.setBackground(new Color(204, 153, 51));
		panel.add(btnC8);
		
		JButton btnD8 = new JButton("d8");
		btnD8.setActionCommand("D8");
		btnD8.setForeground(new Color(255, 255, 255));
		btnD8.setBackground(new Color(102, 51, 0));
		panel.add(btnD8);
		
		JButton btnE8 = new JButton("e8");
		btnE8.setActionCommand("E8");
		btnE8.setForeground(new Color(255, 255, 255));
		btnE8.setBackground(new Color(204, 153, 51));
		panel.add(btnE8);
		
		JButton btnF8 = new JButton("f8");
		btnF8.setActionCommand("F8");
		btnF8.setForeground(new Color(255, 255, 255));
		btnF8.setBackground(new Color(102, 51, 0));
		panel.add(btnF8);
		
		JButton btnG8 = new JButton("g8");
		btnG8.setActionCommand("G8");
		btnG8.setForeground(new Color(255, 255, 255));
		btnG8.setBackground(new Color(204, 153, 51));
		panel.add(btnG8);
		
		JButton btnH8 = new JButton("h8");
		btnH8.setActionCommand("H8");
		btnH8.setForeground(new Color(255, 255, 255));
		btnH8.setBackground(new Color(102, 51, 0));
		panel.add(btnH8);
		
		JButton btnA7 = new JButton("a7");
		btnA7.setActionCommand("A7");
		btnA7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA7.setForeground(new Color(255, 255, 255));
		btnA7.setBackground(new Color(102, 51, 0));
		panel.add(btnA7);
		
		JButton btnB7 = new JButton("b7");
		btnB7.setActionCommand("B7");
		btnB7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB7.setForeground(new Color(255, 255, 255));
		btnB7.setBackground(new Color(204, 153, 51));
		panel.add(btnB7);
		
		JButton btnC7 = new JButton("c7");
		btnC7.setActionCommand("C7");
		btnC7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC7.setForeground(new Color(255, 255, 255));
		btnC7.setBackground(new Color(102, 51, 0));
		panel.add(btnC7);
		
		JButton btnD7 = new JButton("d7");
		btnD7.setActionCommand("D7");
		btnD7.setForeground(new Color(255, 255, 255));
		btnD7.setBackground(new Color(204, 153, 51));
		panel.add(btnD7);
		
		JButton btnE7 = new JButton("e7");
		btnE7.setActionCommand("E7");
		btnE7.setForeground(new Color(255, 255, 255));
		btnE7.setBackground(new Color(102, 51, 0));
		panel.add(btnE7);
		
		JButton btnF7 = new JButton("f7");
		btnF7.setActionCommand("F7");
		btnF7.setForeground(new Color(255, 255, 255));
		btnF7.setBackground(new Color(204, 153, 51));
		panel.add(btnF7);
		
		JButton btnG7 = new JButton("g7");
		btnG7.setActionCommand("G7");
		btnG7.setForeground(new Color(255, 255, 255));
		btnG7.setBackground(new Color(102, 51, 0));
		panel.add(btnG7);
		
		JButton btnH7 = new JButton("h7");
		btnH7.setActionCommand("H7");
		btnH7.setForeground(new Color(255, 255, 255));
		btnH7.setBackground(new Color(204, 153, 51));
		panel.add(btnH7);
		
		JButton btnA6 = new JButton("a6");
		btnA6.setActionCommand("A6");
		btnA6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA6.setForeground(new Color(255, 255, 255));
		btnA6.setBackground(new Color(204, 153, 51));
		panel.add(btnA6);
		
		JButton btnB6 = new JButton("b6");
		btnB6.setActionCommand("B6");
		btnB6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB6.setForeground(new Color(255, 255, 255));
		btnB6.setBackground(new Color(102, 51, 0));
		panel.add(btnB6);
		
		JButton btnC6 = new JButton("c6");
		btnC6.setActionCommand("C6");
		btnC6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC6.setForeground(new Color(255, 255, 255));
		btnC6.setBackground(new Color(204, 153, 51));
		panel.add(btnC6);
		
		JButton btnD6 = new JButton("d6");
		btnD6.setActionCommand("D6");
		btnD6.setForeground(new Color(255, 255, 255));
		btnD6.setBackground(new Color(102, 51, 0));
		panel.add(btnD6);
//TODO: segui con btn.setActionCommand()		
		JButton btnE6 = new JButton("e6");
		btnE6.setForeground(new Color(255, 255, 255));
		btnE6.setBackground(new Color(204, 153, 51));
		panel.add(btnE6);
		
		JButton btnF6 = new JButton("f6");
		btnF6.setForeground(new Color(255, 255, 255));
		btnF6.setBackground(new Color(102, 51, 0));
		panel.add(btnF6);
		
		JButton btnG6 = new JButton("g6");
		btnG6.setForeground(new Color(255, 255, 255));
		btnG6.setBackground(new Color(204, 153, 51));
		panel.add(btnG6);
		
		JButton btnH6 = new JButton("h6");
		btnH6.setForeground(new Color(255, 255, 255));
		btnH6.setBackground(new Color(102, 51, 0));
		panel.add(btnH6);
		
		JButton btnA5 = new JButton("a5");
		btnA5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA5.setForeground(new Color(255, 255, 255));
		btnA5.setBackground(new Color(102, 51, 0));
		panel.add(btnA5);
		
		JButton btnB5 = new JButton("b5");
		btnB5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB5.setForeground(new Color(255, 255, 255));
		btnB5.setBackground(new Color(204, 153, 51));
		panel.add(btnB5);
		
		JButton btnC5 = new JButton("c5");
		btnC5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC5.setForeground(new Color(255, 255, 255));
		btnC5.setBackground(new Color(102, 51, 0));
		panel.add(btnC5);
		
		JButton btnD5 = new JButton("d5");
		btnD5.setForeground(new Color(255, 255, 255));
		btnD5.setBackground(new Color(204, 153, 51));
		panel.add(btnD5);
		
		JButton btnE5 = new JButton("e5");
		btnE5.setForeground(new Color(255, 255, 255));
		btnE5.setBackground(new Color(102, 51, 0));
		panel.add(btnE5);
		
		JButton btnF5 = new JButton("f5");
		btnF5.setForeground(new Color(255, 255, 255));
		btnF5.setBackground(new Color(204, 153, 51));
		panel.add(btnF5);
		
		JButton btnG5 = new JButton("g5");
		btnG5.setForeground(new Color(255, 255, 255));
		btnG5.setBackground(new Color(102, 51, 0));
		panel.add(btnG5);
		
		JButton btnH5 = new JButton("h5");
		btnH5.setForeground(new Color(255, 255, 255));
		btnH5.setBackground(new Color(204, 153, 51));
		panel.add(btnH5);
		
		JButton btnA4 = new JButton("a4");
		btnA4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA4.setForeground(new Color(255, 255, 255));
		btnA4.setBackground(new Color(204, 153, 51));
		panel.add(btnA4);
		
		JButton btnB4 = new JButton("b4");
		btnB4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB4.setForeground(new Color(255, 255, 255));
		btnB4.setBackground(new Color(102, 51, 0));
		panel.add(btnB4);
		
		JButton btnC4 = new JButton("c4");
		btnC4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC4.setForeground(new Color(255, 255, 255));
		btnC4.setBackground(new Color(204, 153, 51));
		panel.add(btnC4);
		
		JButton btnD4 = new JButton("d4");
		btnD4.setForeground(new Color(255, 255, 255));
		btnD4.setBackground(new Color(102, 51, 0));
		panel.add(btnD4);
		
		JButton btnE4 = new JButton("e4");
		btnE4.setForeground(new Color(255, 255, 255));
		btnE4.setBackground(new Color(204, 153, 51));
		panel.add(btnE4);
		
		JButton btnF4 = new JButton("f4");
		btnF4.setForeground(new Color(255, 255, 255));
		btnF4.setBackground(new Color(102, 51, 0));
		panel.add(btnF4);
		
		JButton btnG4 = new JButton("g4");
		btnG4.setForeground(new Color(255, 255, 255));
		btnG4.setBackground(new Color(204, 153, 51));
		panel.add(btnG4);
		
		JButton btnH4 = new JButton("h4");
		btnH4.setForeground(new Color(255, 255, 255));
		btnH4.setBackground(new Color(102, 51, 0));
		panel.add(btnH4);
		
		JButton btnA3 = new JButton("a3");
		btnA3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnA3.setForeground(new Color(255, 255, 255));
		btnA3.setBackground(new Color(102, 51, 0));
		panel.add(btnA3);
		
		JButton btnB3 = new JButton("b3");
		btnB3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB3.setForeground(new Color(255, 255, 255));
		btnB3.setBackground(new Color(204, 153, 51));
		panel.add(btnB3);
		
		JButton btnC3 = new JButton("c3");
		btnC3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC3.setForeground(new Color(255, 255, 255));
		btnC3.setBackground(new Color(102, 51, 0));
		panel.add(btnC3);
		
		JButton btnD3 = new JButton("d3");
		btnD3.setForeground(new Color(255, 255, 255));
		btnD3.setBackground(new Color(204, 153, 51));
		panel.add(btnD3);
		
		JButton btnE3 = new JButton("e3");
		btnE3.setForeground(new Color(255, 255, 255));
		btnE3.setBackground(new Color(102, 51, 0));
		panel.add(btnE3);
		
		JButton btnF3 = new JButton("f3");
		btnF3.setForeground(new Color(255, 255, 255));
		btnF3.setBackground(new Color(204, 153, 51));
		panel.add(btnF3);
		
		JButton btnG3 = new JButton("g3");
		btnG3.setForeground(new Color(255, 255, 255));
		btnG3.setBackground(new Color(102, 51, 0));
		panel.add(btnG3);
		
		JButton btnH3 = new JButton("h3");
		btnH3.setForeground(new Color(255, 255, 255));
		btnH3.setBackground(new Color(204, 153, 51));
		panel.add(btnH3);
		
		JButton btnA2 = new JButton("a2");
		btnA2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				click(e);			
			}
		});
		btnA2.setForeground(new Color(255, 255, 255));
		btnA2.setBackground(new Color(204, 153, 51));
		panel.add(btnA2);
		
		JButton btnB2 = new JButton("b2");
		btnB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB2.setForeground(new Color(255, 255, 255));
		btnB2.setBackground(new Color(102, 51, 0));
		panel.add(btnB2);
		
		JButton btnC2 = new JButton("c2");
		btnC2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC2.setForeground(new Color(255, 255, 255));
		btnC2.setBackground(new Color(204, 153, 51));
		panel.add(btnC2);
		
		JButton btnD2 = new JButton("d2");
		btnD2.setForeground(new Color(255, 255, 255));
		btnD2.setBackground(new Color(102, 51, 0));
		panel.add(btnD2);
		
		JButton btnE2 = new JButton("e2");
		btnE2.setForeground(new Color(255, 255, 255));
		btnE2.setBackground(new Color(204, 153, 51));
		panel.add(btnE2);
		
		JButton btnF2 = new JButton("f2");
		btnF2.setForeground(new Color(255, 255, 255));
		btnF2.setBackground(new Color(102, 51, 0));
		panel.add(btnF2);
		
		JButton btnG2 = new JButton("g2");
		btnG2.setForeground(new Color(255, 255, 255));
		btnG2.setBackground(new Color(204, 153, 51));
		panel.add(btnG2);
		
		JButton btnH2 = new JButton("h2");
		btnH2.setForeground(new Color(255, 255, 255));
		btnH2.setBackground(new Color(102, 51, 0));
		panel.add(btnH2);
		
		JButton btnA1 = new JButton("a1");
		btnA1.setActionCommand("A1");
		btnA1.setText("asd");
		btnA1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				click(e);			
			}
		});
		btnA1.setBackground(new Color(102, 51, 0));
		btnA1.setForeground(new Color(255, 255, 255));
		panel.add(btnA1);
		
		JButton btnB1 = new JButton("b1");
		btnB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnB1.setForeground(new Color(255, 255, 255));
		btnB1.setBackground(new Color(204, 153, 51));
		panel.add(btnB1);
		
		JButton btnC1 = new JButton("c1");
		btnC1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnC1.setForeground(new Color(255, 255, 255));
		btnC1.setBackground(new Color(102, 51, 0));
		panel.add(btnC1);
		
		JButton btnD1 = new JButton("d1");
		btnD1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				click(e);
			}
		});
		btnD1.setForeground(new Color(255, 255, 255));
		btnD1.setBackground(new Color(204, 153, 51));
		panel.add(btnD1);
		
		JButton btnE1 = new JButton("e1");
		btnE1.setForeground(new Color(255, 255, 255));
		btnE1.setBackground(new Color(102, 51, 0));
		panel.add(btnE1);
		
		JButton btnF1 = new JButton("f1");
		btnF1.setForeground(new Color(255, 255, 255));
		btnF1.setBackground(new Color(204, 153, 51));
		panel.add(btnF1);
		
		JButton btnG1 = new JButton("g1");
		btnG1.setForeground(new Color(255, 255, 255));
		btnG1.setBackground(new Color(102, 51, 0));
		panel.add(btnG1);
		
		JButton btnH1 = new JButton("h1");
		btnH1.setForeground(new Color(255, 255, 255));
		btnH1.setBackground(new Color(204, 153, 51));
		panel.add(btnH1);
		
		JPanel panelJugador2 = new JPanel();
		frame.getContentPane().add(panelJugador2, "cell 1 0,grow");
		
		JPanel panelComidas2 = new JPanel();
		frame.getContentPane().add(panelComidas2, "cell 1 1,grow");
		
		JPanel panelInformacionAdicional = new JPanel();
		frame.getContentPane().add(panelInformacionAdicional, "cell 1 2,grow");
		
		JPanel panelComidas1 = new JPanel();
		frame.getContentPane().add(panelComidas1, "cell 1 3,grow");
		
		JPanel panelJugador1 = new JPanel();
		frame.getContentPane().add(panelJugador1, "cell 1 4,grow");
	}
	
	private void click(ActionEvent e){
		
		estado = estado == 0 ? 1 : estado;
		
		switch (estado) {
		
		case 1:
			desde.append(e.getActionCommand());
			estado = 2;
			break;
			
		case 2:
			hasta.append(e.getActionCommand());		
			ca.movimiento(desde.toString(), hasta.toString());
			estado = 0;
			hasta.delete(0, 2);
			desde.delete(0, 2);
			break;

		default:
			break;
		}
		
		ca.actualizarTablero(estado);
		
	}

}
