package com.example.Badge.controller;

import com.example.Badge.model.CommentsStatic;
import com.example.Badge.service.CommentsStaticService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CommentsStaticControllerTest {

    @Mock
    private CommentsStaticService commentsStaticService;

    @InjectMocks
    private CommentsStaticController commentsStaticController;

    @BeforeEach
    void setUp() {
        // Pas besoin de MockMvc si on teste les méthodes directement
    }

    @Test
    void testGetCommentsByUser() {
        List<CommentsStatic> comments = List.of(new CommentsStatic(), new CommentsStatic());
        when(commentsStaticService.getCommentsByUserId("user123")).thenReturn(comments);

        List<CommentsStatic> result = commentsStaticController.getCommentsByUser("user123");

        assertEquals(2, result.size());
        verify(commentsStaticService, times(1)).getCommentsByUserId("user123");
    }

    @Test
    void testSaveComment() {
        CommentsStatic comment = new CommentsStatic();
        when(commentsStaticService.saveComment(comment)).thenReturn(comment);

        CommentsStatic result = commentsStaticController.saveComment(comment);

        assertNotNull(result);
        verify(commentsStaticService, times(1)).saveComment(comment);
    }
}
