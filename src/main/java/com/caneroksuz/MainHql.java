package com.caneroksuz;

import com.caneroksuz.controller.BookController;
import com.caneroksuz.repository.BookRepository;
import com.caneroksuz.repository.BorrowRepository;

import java.util.Arrays;
import java.util.List;

/*
    1- turu novel olan kitapların listesi;
    2- ismi a ile baslayan yazarların kitaplarını getirelim;
    3- Kitap ara fonksiyonu title a gore kitap getiren metodu yazalım
    4- bir kullanıcının yaptıgı odunc almalar
    5- bir kitabı hangi kullanıcılar ödunc almıs
    6- Her kitap turunden kac adet kitap vardır;
    7- Odunc alma metodu ==>
    bir kiralanabilir kitapları listeleyeceğiz
    daha sonra bir kullanıcı bilgisi alacagız
    daha sonra kac gun kiralamak istediğimizi gireceğiz ve sonunda bir kiralama gerçekleştireceğiz.
    (Uyarı: kiralama sonucu gerçekleşen değişiklikleri database de guncellemeyi unutmayın)
 */
public class MainHql {
    public static void main(String[] args) {
        BookController bookController = new BookController();
        BookRepository bookRepository = new BookRepository();
        BorrowRepository borrowRepository = new BorrowRepository();
//        bookController.getBooksByType(EBookType.NOVEL).forEach(System.out::println);
//        bookController.getBooksWithAuthorNameStartWith("A").forEach(System.out::println);

        // Criteria ile yapıldı...
//        bookRepository.getBooksByTypeWithCriteria(EBookType.NOVEL).forEach(System.out::println);
        // NamedQuery ile yapıldı...
//        bookRepository.getBooksByTypeNamedQuery(EBookType.NOVEL).forEach(System.out::println);

        //System.out.println(bookRepository.findByTitle("Esir Sehrin insanları"));

//        bookRepository.findByTitle2("Yabancı").forEach(System.out::println);

//        List<Book> list = bookRepository.findByTitleWithCriteria("Yabancı");
/*        List<Object[]> list = bookRepository.findByTitleWithCriteria2("Yabancı");
        for (Object[] array: list) {
            System.out.println(Arrays.toString(array));
        }*/

//        borrowRepository.getBorrowsByUser(1L).forEach(System.out::println);

//        borrowRepository.getUsersByBookId(6L).forEach(System.out::println);

/*
        List<Object[]> list = bookRepository.getBooksCountByBookType();
        for (Object[] array: list) {
            System.out.println(Arrays.toString(array));
        }
*/

        List<Object[]> list = bookRepository.getBooksCountByBookTypeWithCriteria();
        for (Object[] array: list) {
            System.out.println(Arrays.toString(array));
        }


    }

}
