package core;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FormLayout;
import java.io.File;

import javafx.embed.swt.FXCanvas;
import javafx.scene.media.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

public class SwtMain {
	
	File sfx1;
	File sfx2;
	AudioClip ac;
	MediaPlayer mp;
	Media menuLoop=new Media(getClass().getClassLoader().getResource("880830.wav").toString());
	Media battle=new Media(getClass().getClassLoader().getResource("battleLoop.wav").toString());
	MediaView mv;
	FXCanvas fxc;
	
	protected Shell shlFairyQuest;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			SwtMain window = new SwtMain();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFairyQuest.open();
		shlFairyQuest.layout();
		while (!shlFairyQuest.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlFairyQuest = new Shell();
		shlFairyQuest.setSize(450, 300);
		shlFairyQuest.setText("Fairy Quest");
		shlFairyQuest.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlFairyQuest, SWT.NONE);
		composite.setLayout(new GridLayout(3, false));
		FormData fd_composite = new FormData();
		fd_composite.bottom = new FormAttachment(100, -10);
		fd_composite.right = new FormAttachment(100, -10);
		composite.setLayoutData(fd_composite);
		
		Button btnJugar = new Button(composite, SWT.NONE);
		btnJugar.setText("Jugar");
		
		Button btnOpciones = new Button(composite, SWT.NONE);
		btnOpciones.setText("Opciones");
		
		Button btnSalir = new Button(composite, SWT.NONE);
		btnSalir.setText("Salir");

	}
}
