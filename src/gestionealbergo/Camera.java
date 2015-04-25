package gestionealbergo;

import java.util.*;
import java.time.*;

public abstract class Camera {
	private String numero;
	private int postiLetto;
	private Vector<Prenotazione> prenotazioni;
	
	Camera(String numero, int postiLetto) {
		if (numero!=null)
			this.numero = numero;
		else
			throw new IllegalArgumentException("numero non può essere null");
		if (postiLetto>0)
			this.postiLetto = postiLetto;
		else
			throw new IllegalArgumentException("postiLetto deve essere positivo");
		this.prenotazioni = new Vector<Prenotazione>();
	}

	public String getNumero() {
		return numero;
	}

	public int getPostiLetto() {
		return postiLetto;
	}
	
	public Vector<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	
	public boolean isDisponibile(LocalDateTime dal, LocalDateTime al) {
		boolean b = true;
		for(Prenotazione p : prenotazioni) {
			if ( !dal.isAfter(p.getAl()) && !al.isBefore(p.getDal()))
				b  = false;
		}
		return b;
	}
	
	public void addPrenotazione(Prenotazione p) throws Exception {
		if( p!=null) {
			if (this.isDisponibile(p.getDal(), p.getAl())) {
				p.setCamera(this);
				prenotazioni.add(p);
			}
			else
				throw new Exception("camera non disponibile");
		}
		else
			throw new IllegalArgumentException("prenotazione non può essere null");
	}

	@Override
	public String toString() {
		return "Camera [numero=" + numero + ", postiLetto=" + postiLetto + ", prenotazioni = " + prenotazioni.size() +"]";
	}
}