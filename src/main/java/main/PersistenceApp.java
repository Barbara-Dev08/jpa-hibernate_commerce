package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Articulo;
import entidades.Categoria;
import entidades.Cliente;
import entidades.DetalleFactura;
import entidades.Domicilio;
import entidades.Factura;

public class PersistenceApp {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceAppPU");
		EntityManager em = emf.createEntityManager();
		
		try {
			em.getTransaction().begin();
			
			/*Factura factura1 = Factura.builder()
					.numero(12)
					.fecha("21/09/2022")
					.build();
			
			Domicilio dom1 = Domicilio.builder()
					.nombreCalle("San Martin Sur")
					.numero(1300)
					.build();
			Cliente cliente1 = Cliente.builder()
					.nombre("Juan")
					.apellido("Honguito")
					.dni(34000000)
					.build();
			
			cliente1.setDomicilio(dom1);
			
			dom1.setCliente(cliente1);
			
			factura1.setCliente(cliente1);
			
			Categoria perecederos = Categoria.builder()
					.denominacion("perecederos")
					.build();
			Categoria lacteos = Categoria.builder()
					.denominacion("lacteos")
					.build();
			Categoria limpieza = Categoria.builder()
					.denominacion("limpieza")
					.build();
			
			Articulo art1 = Articulo.builder()
					.cantidad(200)
					.denominacion("Yogurt Ser")
					.precio(200)
					.build();
			Articulo art2 = Articulo.builder()
					.cantidad(300)
					.denominacion("Detergente Magistral")
					.precio(450)
					.build();
			
			art1.getCategorias().add(perecederos);
			art1.getCategorias().add(lacteos);
			
			lacteos.getArticulos().add(art1);
			perecederos.getArticulos().add(art1);
			
			art2.getCategorias().add(limpieza);
			limpieza.getArticulos().add(art2);
			
			DetalleFactura detalleF1 = DetalleFactura.builder()
					.articulo(art1)
					.cantidad(2)
					.build();
			
			art1.getDetallle().add(detalleF1);
			factura1.getDetalles().add(detalleF1);
			detalleF1.setFactura(factura1);
			
			DetalleFactura detalleF2 = DetalleFactura.builder()
					.articulo(art2)
					.cantidad(1)
					.subtotal(450)
					.build();
			
			art2.getDetallle().add(detalleF2);
			factura1.getDetalles().add(detalleF2);
			detalleF2.setFactura(factura1);
			
			factura1.setTotal(950);*/
			
			Factura factura1 = em.find(Factura.class, 1L);
//			factura1.setNumero(85);
			//actualiza:
//			em.merge(factura1);
			
			//elimina:
			em.remove(factura1);
			
//			em.persist(factura1);
			
			//limpia la conexion con la DB
			em.flush();
			
			//commit deñ persist
			em.getTransaction().commit();
		} catch (Exception e) {
			//en caso de error permite que regrese al estado anterior
			em.getTransaction().rollback();
		}
		
		//cierra la conexion
		em.close();
	}
}
