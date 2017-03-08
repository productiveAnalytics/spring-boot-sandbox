package com.productiveAnalytics.libraryApp.controller;

import java.net.URI;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.productiveAnalytics.libraryApp.exceptions.BookNotFoundException;
import com.productiveAnalytics.libraryApp.model.Book;
import com.productiveAnalytics.libraryApp.service.BookService;

@Component
@Path("/books")
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	
/***  start of GET methods ***/ 
	@GET
	@Produces("application/json")
	public Collection<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@GET
	@Produces("application/json")
	@Path("/{oid}")
	public Book getBook(@PathParam("oid") String oid) {
		Book b = bookService.getBook(oid);
		if (b == null) 
			throw new BookNotFoundException("Unable to find book: "+ oid);
		else 
			return b;
	}
/***  end of GET methods ***/

	
/***  start of POST methods ***/
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/add")
	public Response addBook(Book newBook) {
		bookService.addBook(newBook);
		System.out.println("Added book, oid="+ newBook.getOid());
		return Response.created(URI.create("/" + newBook.getOid())).build();
	}
/***  end of POST methods ***/
	

/***  start of PUT methods ***/
	@PUT
	@Consumes("application/json")
	@Path("/{oid}")
	public Response updateBook(@PathParam("oid") String oid, Book book) {
		bookService.updateBook(oid, book);
		System.out.println("Updated book, oid="+ oid);
		return Response.noContent().build();
	}
/***  end of PUT methods ***/

	
/***  start of DELETE methods ***/
	@DELETE
	@Path("/{oid}")
	public Response deleteBook(@PathParam("oid") String oid) {
		bookService.deleteBook(oid);
		System.out.println("Deleted book, oid="+ oid);
		return Response.ok().build();
	}
/***  end of DELETE methods ***/
}