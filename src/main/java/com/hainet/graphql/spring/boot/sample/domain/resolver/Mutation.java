package com.hainet.graphql.spring.boot.sample.domain.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.hainet.graphql.spring.boot.sample.domain.dao.AuthorDao;
import com.hainet.graphql.spring.boot.sample.domain.dao.BookDao;
import com.hainet.graphql.spring.boot.sample.domain.model.Author;
import com.hainet.graphql.spring.boot.sample.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    private final BookDao bookDao;
    private final AuthorDao authorDao;

    public Book createBook(final String title, final int authorId) {
        final Book book = new Book();
        book.setTitle(title);
        book.setAuthorId(authorId);

        bookDao.insert(book);

        return book;
    }

    public Author createAuthor(final String name) {
        final Author author = new Author();
        author.setName(name);

        authorDao.insert(author);

        return author;
    }
}
