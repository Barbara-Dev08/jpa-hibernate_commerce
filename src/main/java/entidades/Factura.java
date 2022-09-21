package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Audited
public class Factura implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha")
	private String fecha;
	
	@Column(name = "numero")
	private int numero;
	
	@Column(name = "total")
	private int total;
	
	//creacion de relaciones:
	
	//RELACION CLIENTE:
	
	//solo se persiste el cliente al generar la factura
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_cliente")
	private Cliente cliente;
	
	
	
	
	//Relacion DETALLESFACTURA:
	
	//cuando se elimine la factura se elimina los detalles
	//unidireccional:
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	
	//private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	//bidireccional:
	@OneToMany(mappedBy = "factura" ,
			cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
	
	
	
	
}
