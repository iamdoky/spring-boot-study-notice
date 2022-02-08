package com.study.notice.controller;

import com.study.notice.Service.LibraryService;
import com.study.notice.model.Book;
import com.study.notice.model.Member;
import com.study.notice.model.request.BookCreationRequest;
import com.study.notice.model.request.BookLendRequest;
import com.study.notice.model.request.MemberCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : HP
 * @version 1.0
 * <p>
 * Copyright (C) 2010 by G-INNO  All right reserved.
 * @Class Name : LibraryController
 * @Description :
 * @Modification Information
 * <p>
 * 수정일           수정자          수정내용
 * -------------------------------------------------------
 * 2022.02.08      HP        수정내용 1
 * 2010-04-10      O O O        수정내용 2
 * @since 2022.02.08
 */
@RestController
@RequestMapping( value="/api/library" )
@RequiredArgsConstructor
public class LibraryController {
    private final LibraryService libraryService;

    @GetMapping( "/book" )
    public ResponseEntity readBooks( @RequestParam( required = false ) String isbn ) {
        if ( isbn == null ) {
            return ResponseEntity.ok(libraryService.readBooks());
        }
        return ResponseEntity.ok(libraryService.readBook());
    }

    @GetMapping( "/book/{bookId}" )
    public ResponseEntity<Book> readBook (@PathVariable Long bookId ) {
        return ResponseEntity.ok(libraryService.readBook(bookId));
    }

    @PostMapping( "/book" )
    public ResponseEntity<Book> creatrBook ( @RequestBody BookCreationRequest request ) {
        return ResponseEntity.ok(libraryService.createBook(request));
    }

    @PostMapping( "/book/{bookId}" )
    public ResponseEntity<Void> deleteBook ( @PathVariable Long bookId ) {
        libraryService.deleteBook( bookId );
        return ResponseEntity.ok().build();
    }

    @PostMapping( "/member" )
    public ResponseEntity<Member> createMember (@RequestBody MemberCreationRequest request) {
        return ResponseEntity.ok(libraryService.createMember(request));
    }

    @PostMapping( "/member/{memberId}" )
    public ResponseEntity<Member> updateMember ( @RequestBody MemberCreationRequest request, @PathVariable Long memberId ) {
        return ResponseEntity.ok(libraryService.updateMember(memberId, request));
    }

    @PostMapping( "/book/lend" )
    public ResponseEntity<list<String>> lendABook(@RequestBody BookLendRequest bookLendRequest ) {
        return ResponseEntity.ok(libraryService.lendABook(bookLendRequest));
    }

    @PostMapping("/author")
    public ResponseEntity<Author> createAuthor (@RequestBody AuthorCreationRequest request) {
        return ResponseEntity.ok(libraryService.createAuthor(request));
    }


}
