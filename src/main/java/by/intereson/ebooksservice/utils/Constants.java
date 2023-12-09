package by.intereson.ebooksservice.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constants {
    /**
     * PARAMETERS
     */
    public static final String NAME_USER = "name";
    public static final String SURNAME_USER = "surname";
    public static final String MAIL_USER = "mail";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String BOOK_NAME = "bookName";
    public static final String AUTHOR = "author";
    public static final String YEAR_OF_PUBLISHING = "yearOfPublishing";
    public static final String PUBLISHING_HOUSE = "publishingHouse";
    public static final String ANNOTATION = "annotation";
    public static final String PRICE = "price";
    public static final String USER_TYPE = "userType";
    public static final String BOOKS = "books";
    public static final String BOOK = "book";
    public static final String ID = "id";
    public static final String USERS = "users";
    public static final String USER = "user";
    public static final String DATE_FORMAT = "dd.MM.uuuu HH-mm";
    public static final Integer MAX_INACTIVE_INTERVAL_SESSION = 86400;
    /**
     * PAGES
     */
    public static final String USERS_PAGE = "/pages/users/readUsers.jsp";
    public static final String USERS_REGISTRATION_PAGE = "/pages/users/createUser.jsp";
    public static final String USERS_DELETE_PAGE = "/pages/users/deleteUser.jsp";
    public static final String USERS_UPDATE_PAGE = "/pages/users/updateUser.jsp";
    public static final String USERS_AUTHENTICATION_PAGE = "/pages/users/authentication.jsp";

    public static final String BOOKS_FOR_ADMIN_PAGE = "/pages/books/readBooksForAdmin.jsp";
    public static final String BOOK_CREATE_PAGE = "/pages/books/createBook.jsp";
    public static final String BOOKS_DELETE_PAGE = "/pages/books/deleteBook.jsp";
    public static final String BOOKS_UPDATE_PAGE = "/pages/books/updateBook.jsp";
    public static final String BOOKS_FOR_USER_PAGE = "/pages/books/readBooksForUser.jsp";
    public static final String BOOKS_FOR_LOGGING_USER_PAGE = "/pages/books/readBooksForLoggingUser.jsp";

    public static final String ERROR_ACCESS_PAGE = "/pages/errors/errorAccess.jsp";
    public static final String ERROR_DATA_PAGE = "/pages/errors/errorData.jsp";
    public static final String ERROR_DATA_BOOK_PAGE = "/pages/errors/errorDataBookPage.jsp";
    public static final String ERROR_LOGIN_OR_EMAIL_PAGE = "/pages/errors/ErrorLogin.jsp";

    /**
     * URL
     */
    public static final String USERS_AUTHENTICATION_URL = "/users/authentication";
    public static final String USERS_CREATE_URL = "/users/create";
    public static final String USERS_DELETE_URL = "/users/delete";
    public static final String USERS_READ_URL = "/users/read";
    public static final String USERS_REGISTRATION_URL = "/users/registration";
    public static final String USERS_UPDATE_URL = "/users/update";

    public static final String BOOKS_UPDATE_URL = "/books/update";
    public static final String BOOKS_CREATE_URL = "/books/create";
    public static final String BOOKS_READ_URL = "/books/read";
    public static final String BOOKS_DELETE_URL = "/books/delete";

    public static final String MAIN_PAGE_URL = "/main";
    public static final String EXIT_URL = "/exit";


}
