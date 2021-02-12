package core;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import javafx.embed.swt.FXCanvas;

import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Scale;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;

public class SwtSetts extends Dialog {
	
	AudioHandler ah=new AudioHandler();
	SwtMain swtm=new SwtMain();

	protected Object result;
	protected Shell shlAjustes;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public SwtSetts(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlAjustes.open();
		shlAjustes.layout();
		Display display = getParent().getDisplay();
		while (!shlAjustes.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlAjustes = new Shell(getParent(), getStyle());
		shlAjustes.setSize(323, 247);
		shlAjustes.setText("Ajustes");
		shlAjustes.setLayout(new FormLayout());
		
		Group grpSonido = new Group(shlAjustes, SWT.NONE);
		grpSonido.setText("Sonido");
		grpSonido.setLayout(new GridLayout(1, false));
		FormData fd_grpSonido = new FormData();
		fd_grpSonido.top = new FormAttachment(0, 10);
		fd_grpSonido.left = new FormAttachment(0, 10);
		grpSonido.setLayoutData(fd_grpSonido);
		
		Composite composite = new Composite(grpSonido, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));
		
		Label lblMsica = new Label(composite, SWT.NONE);
		lblMsica.setText("M\u00FAsica");
		new Label(composite, SWT.NONE);
		
		Scale musicVol = new Scale(composite, SWT.NONE);
		musicVol.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(swtm.mp!=null) {
					swtm.mp.setVolume((double)musicVol.getSelection()/100);
				}
			}
		});
		musicVol.setSelection(100);
		
		Button btnSilenciarMsica = new Button(composite, SWT.CHECK);
		btnSilenciarMsica.setText("Silenciar m\u00FAsica");
		
		Composite composite_1 = new Composite(grpSonido, SWT.NONE);
		composite_1.setLayout(new GridLayout(2, false));
		
		Label lblEfectosDeSonido = new Label(composite_1, SWT.NONE);
		lblEfectosDeSonido.setText("Efectos de sonido");
		new Label(composite_1, SWT.NONE);
		
		Scale sfxVol = new Scale(composite_1, SWT.NONE);
		sfxVol.setSelection(100);
		
		Button btnSilenciarSfx = new Button(composite_1, SWT.CHECK);
		btnSilenciarSfx.setText("Silenciar SFX");
		
		Button btnSalir = new Button(shlAjustes, SWT.NONE);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlAjustes.dispose();
			}
		});
		FormData fd_btnSalir = new FormData();
		fd_btnSalir.top = new FormAttachment(grpSonido, 6);
		fd_btnSalir.left = new FormAttachment(0, 10);
		btnSalir.setLayoutData(fd_btnSalir);
		btnSalir.setText("Salir");

	}
}
