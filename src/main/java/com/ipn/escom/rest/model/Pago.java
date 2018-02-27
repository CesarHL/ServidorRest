package com.ipn.escom.rest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "spe01_pago")
public class Pago implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "spe01_pago_id_pago_seq", sequenceName = "spe01_pago_id_pago_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tad01_pago_id_pago_seq")
	@Column(name = "id_pago")
	private Integer id;

	@Column(name = "")
	private Double cantidad;

	@Column(name = "")
	private String folio;

	@Column(name = "")
	private String receptor;

	@Column(name = "")
	private String emisor;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo", referencedColumnName = "id_tipo", insertable = false, updatable = false)
	private TipoPago tipo;

	public Pago() {
		super();
	}

	public Pago(Integer id, Double cantidad, String folio, String receptor, String emisor) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.folio = folio;
		this.receptor = receptor;
		this.emisor = emisor;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the cantidad
	 */
	public Double getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio
	 *            the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the receptor
	 */
	public String getReceptor() {
		return receptor;
	}

	/**
	 * @param receptor
	 *            the receptor to set
	 */
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}

	/**
	 * @return the emisor
	 */
	public String getEmisor() {
		return emisor;
	}

	/**
	 * @param emisor
	 *            the emisor to set
	 */
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pago [id=" + id + ", cantidad=" + cantidad + ", folio=" + folio + ", receptor=" + receptor + ", emisor="
				+ emisor + "]";
	}

}
