package com.giraudev.soapserver.service;

import com.giraudev.soapserver.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticleByArticleId(long articleId){
        return articleRepository.findByArticleId(articleId);
    }

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public synchronized boolean addArticle(Article article){
        List<Article> articles = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
        if (articles.size() > 0) {
            return false;
        } else {
            articleRepository.save(article);
            return true;
        }
    }

    public void updateArticle(Article article){
        articleRepository.save(article);
    }

    public void deleteArticle(Article article){
        articleRepository.delete(article);
    }
}
