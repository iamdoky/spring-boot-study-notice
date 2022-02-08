package com.study.notice.controller;

import com.study.notice.Service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
