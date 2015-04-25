package gestionealbergo;

import java.time.*;

public class Prenotazione {
	private LocalDateTime dal;
	private LocalDateTime al;
	private Camera camera;
	private Cliente cliente;
	
	public Prenotazione(LocalDateTime dal, LocalDateTime al, Cliente cliente) {
		if (dal!=null && al!=null) {
			if (dal.isBefore(al)) {
				this.dal = dal;
				this.al = al;
			}
			else
				throw new IllegalArgumentException("dal deve essere prima di al");
		}
		else
			throw new IllegalArgumentException("al o/e dal non possono essere null");
		if (cliente!=null)
			this.cliente = cliente;
		else
			throw new IllegalArgumentException("cliente non pu� essere null");
	}

	public Camera getCamera() {
		return camera;
	}

	public void setCamera(Camera camera) {
		if (camera!=null)
			this.camera = camera;
		else
			throw new IllegalArgumentException("camera non pu� essere null");
	}

	public LocalDateTime getDal() {
		return dal;
	}

	public LocalDateTime getAl() {
		return al;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public int getNumeroNotti() {
		return Period.between(dal.toLocalDate(), al.toLocalDate()).getDays();
	}

	@Override
	public String toString() {
		return "Prenotazione [dal=" + dal + ", al=" + al + ", camera=" + camera
				+ ", cliente=" + cliente + ", getNumeroNotti()="
				+ getNumeroNotti() + "]";
	}
}