Jersey based REST application using Spring boot

mvn spring-boot:run

Use POSTMAN Chrome extension to test REST calls like

/rest/books/		GET	: getAllBooks()
/rest/books/add		POST	: addBook(book)			# Provide book in JSON format
/rest/books/{oid}	GET	: getBook(oid)
/rest/{oid}		PUT	: updateBook(oid, book)		# Provide book in JSON format
/rest/{oid}		DELETE	: deleteBook(oid)