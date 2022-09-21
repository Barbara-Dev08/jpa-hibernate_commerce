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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Audited
public class Articulo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cantidad")
	 private int cantidad;
	
	@Column(name = "denominacion")
	 private String denominacion;
	
	@Column(name = "precio")
	 private int precio;
	
	
	//creacion de la relacion:
	
	//DETALLEFACTURA
	
	@OneToMany(mappedBy = "articulo")
	@Builder.Default
	private List<DetalleFactura> detallle = new ArrayList<DetalleFactura>();
	
	
	//CATEGORIA:
	

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "articulo_categoria",
			joinColumns = @JoinColumn(name = "articulo_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	@Builder.Default
	private List<Categoria> categorias = new ArrayList<Categoria>();
		
	
	

	
	
	
	
	
	

}
