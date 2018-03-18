package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
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
public class Query implements GraphQLQueryResolver {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public Iterable<Book> findBooks() {
        return bookDao.findAll();
    }

    public Iterable<Publisher> findPublishers() {
        return publisherDao.findAll();
    }

    public Iterable<Author> findAuthors() {
        return authorDao.findAll();
    }
}
