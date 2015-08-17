package presentacion;

import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.ControladorAjedrez;
import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;

import entidades.Jugador;
import excepciones.ApplicationException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class Login {
	
	private ControladorAjedrez ca;

	private JFrame frame;
	private JTextField txtBlancas;
	private JTextField txtNegras;
	private JButton btnContinuar;
	private JButton btnBuscar;
	private JButton btnCrearJugadores;
	private JLabel lblJugador;
	private JLabel lblJugador_1;
	private JTextField txtBlancasNick;
	private JTextField txtNegrasNick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setEnabled(false);
		frame.setBounds(100, 100, 429, 239);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow,left][40px][40px,grow][10px,center][40px][right]", "[top][fill][10,center][center][10px,center][center][10][][grow,bottom]"));
		
		lblJugador = new JLabel("Jugador 1");
		frame.getContentPane().add(lblJugador, "cell 0 0,alignx trailing");
		
		txtBlancas = new JTextField();
		txtBlancas.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtBlancas.setText(txtBlancas.getText().equals("DNI Blancas")?"":txtBlancas.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtBlancas.setText(txtBlancas.getText().length() == 0?"DNI Blancas":txtBlancas.getText());
			}
		});
		txtBlancas.setText("DNI Blancas");
		frame.getContentPane().add(txtBlancas, "cell 1 0 2 1,growx");
		txtBlancas.setColumns(10);
		
		txtBlancasNick = new JTextField();
		txtBlancasNick.setHorizontalAlignment(SwingConstants.RIGHT);
		txtBlancasNick.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtBlancasNick, "cell 4 0 2 1,growx");
		txtBlancasNick.setColumns(10);
		
		lblJugador_1 = new JLabel("Jugador 2");
		frame.getContentPane().add(lblJugador_1, "cell 0 1,alignx right");
		
		txtNegras = new JTextField();
		txtNegras.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtNegras.setText(txtNegras.getText().equals("DNI Negras")?"":txtNegras.getText());
			}
			@Override
			public void focusLost(FocusEvent e) {
				txtNegras.setText(txtNegras.getText().length() == 0?"DNI Negras":txtNegras.getText());
			}
		});
		txtNegras.setText("DNI Negras");
		frame.getContentPane().add(txtNegras, "cell 1 1 2 1,growx");
		txtNegras.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar(txtBlancas.getText(), txtNegras.getText());				
			}
		});
		
		txtNegrasNick = new JTextField();
		txtNegrasNick.setBackground(SystemColor.menu);
		frame.getContentPane().add(txtNegrasNick, "cell 4 1 2 1,growx");
		txtNegrasNick.setColumns(10);
		frame.getContentPane().add(btnBuscar, "cell 1 3,grow");
		
		btnCrearJugadores = new JButton("Crear jugadores");
		btnCrearJugadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: programar
			}
		});
		frame.getContentPane().add(btnCrearJugadores, "cell 4 3,grow");
		
		JButton btnJuegoNuevo = new JButton("Juego nuevo");
		btnJuegoNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal vp = new VentanaPrincipal(); 
				vp.main(null);//TODO:agegar parámetros
			}
		});
		frame.getContentPane().add(btnJuegoNuevo, "cell 1 5,grow");
		
		btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: programar
			}
		});
		frame.getContentPane().add(btnContinuar, "cell 1 7,grow");
	}
	
	private void buscar(String j1, String j2){
		try {
//			Jugador[] jugadores = new Jugador[2];
			ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
			System.out.println(txtBlancas.getText() + " y " + txtNegras.getText());
			jugadores = ca.buscar(txtBlancas.getText(), txtNegras.getText());
//			ca.buscar(j1, j2);
			if(!jugadores.get(0).equals(null)){
				
				JTextField xField = new JTextField(5);
			    JTextField yField = new JTextField(5);
			
				JPanel myPanel = new JPanel();
			    myPanel.add(new JLabel("x:"));
			    myPanel.add(xField);
			    myPanel.add(Box.createHorizontalStrut(15)); // a spacer
			    myPanel.add(new JLabel("y:"));
			    myPanel.add(yField);

			    int result = JOptionPane.showConfirmDialog(null, myPanel, 
			             "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
			    if (result == JOptionPane.OK_OPTION) {
			       System.out.println("x value: " + xField.getText());
			       System.out.println("y value: " + yField.getText());
			    }
//				JOptionPane.showInputDialog(parentComponent, message)
			}
					
		} catch (ApplicationException ae) {
			JOptionPane.showMessageDialog(null, ae.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
