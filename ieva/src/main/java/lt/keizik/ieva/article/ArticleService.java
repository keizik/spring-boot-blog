package lt.keizik.ieva.article;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {

	private ArticleDao articleDao;

	public ArticleService(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	public List<Article> getArticles() {
		return articleDao.findByOrderByIdDesc();
	}

	public Article getArticle(Long id) {
		return articleDao.getOne(id);
	}

	public Article save(Article blog) {
		return articleDao.save(blog);
	}

	public void delete(Long id) {
		articleDao.deleteById(id);
	}

	public List<Article> getByTitle(String title) {
		return articleDao.findByTitle(title);
	}

}
