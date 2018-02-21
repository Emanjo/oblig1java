import java.awt.Frame;
import java.awt.Scrollbar;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
public class Scaler extends Frame implements AdjustmentListener {
	private Scrollbar scrollbar = new Scrollbar(Scrollbar.VERTICAL,0,0,0,101);
	private ScaleWindow scaler = new ScaleWindow();
	private int bildeHoyde = scaler.getBildeHoyde();
	private int bildeLengde = scaler.getBildeLengde();
	
	public Scaler() {
		setTitle("Scaler");
		setSize(50,700);
		add(scrollbar);
		scrollbar.addAdjustmentListener(this);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		
		setVisible(true);
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		int scrollbarVerdi = scrollbar.getValue();
		scaler.setBildeHoyde(scrollbarVerdi * bildeHoyde / 100);
		scaler.setBildeLengde(scrollbarVerdi * bildeLengde / 100);
		scaler.repaint();
		System.out.println(scaler.getBildeLengde() + "px*" + scaler.getBildeHoyde() + "px");
		//System.out.println(scrollbarVerdi);
	}

}
