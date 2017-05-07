package lt.keizik.ieva.article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDao extends JpaRepository<Article, Long> {

	public List<Article> findByTitle(String title);

	public List<Article> findByOrderByIdDesc();

}
