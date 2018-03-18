package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.AuthorDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.PublisherDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Author;
import com.hainet.graphql.spring.boot.sample.domain.model.Book;
import com.hainet.graphql.spring.boot.sample.domain.model.Publisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {

    private final PublisherDao publisherDao;

    private final AuthorDao authorDao;

    public Publisher getPublisher(final Book book) {
        return this.publisherDao.findById(book.getPublisherId());
    }

    public List<Author> getAuthors(final Book book) {
        return this.authorDao.findByBookId(book.getId());
    }
}
