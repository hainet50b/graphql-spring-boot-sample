package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.AuthorDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.BookDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.PublisherDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Author;
import com.hainet.graphql.spring.boot.sample.domain.model.Book;
import com.hainet.graphql.spring.boot.sample.domain.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public Book createBook(final String title, final int publisherId, final int authorId) {
        final Book book = new Book();
        book.setTitle(title);
        book.setPublisherId(publisherId);
        book.setAuthorId(authorId);

        bookDao.insert(book);

        return book;
    }

    public boolean relateAuthorToBook(final int bookId, final int authorId) {
        return bookDao.relateAuthorToBook(bookId, authorId) > 0;
    }

    public Publisher createPublisher(final String name) {
        final Publisher publisher = new Publisher();
        publisher.setName(name);

        publisherDao.insert(publisher);

        return publisher;
    }

    public Author createAuthor(final String name) {
        final Author author = new Author();
        author.setName(name);

        authorDao.insert(author);

        return author;
    }
}
