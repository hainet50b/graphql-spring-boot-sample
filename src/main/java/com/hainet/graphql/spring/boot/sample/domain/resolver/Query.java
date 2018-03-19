package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.AuthorDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.BookDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.PublisherDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Author;
import com.hainet.graphql.spring.boot.sample.domain.model.Book;
import com.hainet.graphql.spring.boot.sample.domain.model.BookFilter;
import com.hainet.graphql.spring.boot.sample.domain.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public Iterable<Book> findBooks(final BookFilter filter) {
        return this.bookDao.findAll().stream()
                .filter(it -> filter.getIds() == null || filter.getIds().contains(it.getId()))
                .filter(it -> filter.getTitles() == null || filter.getTitles().contains(it.getTitle()))
                .filter(it -> filter.getPublisherIds() == null || filter.getPublisherIds().contains(it.getPublisherId()))
                .filter(it -> filter.getAuthorIds() == null || filter.getAuthorIds().contains(it.getAuthorId()))
                .collect(Collectors.toList());
    }

    public Iterable<Publisher> findPublishers() {
        return this.publisherDao.findAll();
    }

    public Iterable<Author> findAuthors() {
        return this.authorDao.findAll();
    }
}
