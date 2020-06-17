# springboot-mybatis-sakila-sample
springboot-mybatis-sakila-sample
 
>条件查询
 ```java
  /**
     * 条件查询
     * @param filmList
     * @return
     */
    List<FilmList> selectByCondition(FilmList filmList);
```
>mapper xml动态条件查询
```xml
 <!--动态条件查询-->
    <select id="selectByCondition"
            parameterType="com.example.domain.FilmList"
            resultType="com.example.domain.FilmList">
        SELECT FID, title, category, price, `length`, rating, description, actors
        FROM film_list
        <where>
            <if test="title !=null and title!='' ">
                AND title LIKE CONCAT('%',#{title},'%')
            </if>
            <if test="category !=null and category!='' ">
                AND category LIKE CONCAT('%',#{category},'%')
            </if>
            <if test="rating !=null and rating!='' ">
                AND rating LIKE CONCAT('%',#{rating},'%')
            </if>
            <if test="description !=null and description!='' ">
                AND description LIKE CONCAT('%',#{description},'%')
            </if>
            <if test="actors !=null and actors!='' ">
                AND actors LIKE CONCAT('%',#{actors},'%')
            </if>
        </where>
    </select>
``` 
>yaml config
```yaml
# 配置端口
server:
  port: 8080
spring:
  # 配置数据源
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/sakila?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource
# mybatis-plus相关配置
# pagehelper
pagehelper:
  helperDialect: mysql
  reasonable: true
  supportMethodsArguments: true
  params: count=countSql


mybatis:
  typeAliasesPackage: com.example.domain
  mapper-locations: classpath:mybatis/mapper/*.xml
  configuration:
    # 缓存开启
    cache-enabled: true
    # 懒加载开启
    lazy-loading-enabled: true
    # SQL打印日志所使用的日志类 - 关键
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

mapper:
  mappers: com.example.dao
  identity: mysql


```



####  es 查询

> ES查询description字段包含关键字的数据
```java
 @Test
    public void textSearch() {
        String queryWord = "Girl";
        CriteriaQuery query = new CriteriaQuery(new Criteria("description").contains(queryWord));
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(query, FilmList.class);
        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            log.info("filmList:{}", filmList);
        }
    }

```

> ES查询description字段包含关键字的数据
```java

    /**
     * 查询description字段包含关键字的数据
     */
    @Test
    public void testQueryFilmListFlux() {
        String queryWord = "Girl";
        Flux<FilmList> filmListFlux = filmService.findAllByDescriptionLike(queryWord);
        Iterator<FilmList> filmListIterator = filmListFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            FilmList filmList = filmListIterator.next();
            System.out.println(filmList.toString());
        }
    }
```

> ES 高亮&分页查询
```java
     /**
     * NativeSearchQuery
     */
    @Test
    public void queryHighLightSearchQuery() {
        List<FilmList> filmListList = new ArrayList<>();
        // 查询的关键字
        String queryWord = "Girl";
        // 查询的字段
        String field = "description";
        // page
        Integer page = 1;
        // pageSize
        Integer pageSize = 50;
        // 高亮设置
        String preTags = "<span style=\"color:#F56C6C\">";
        String postTags = "</span>";
        IndexCoordinates index = IndexCoordinates.of(stringIndex);
        //创建builder
        NativeSearchQuery searchQuery =
                new NativeSearchQueryBuilder()
                        .withQuery(QueryBuilders.matchQuery(field, queryWord))
                        .withHighlightBuilder(new HighlightBuilder().field(field).preTags(preTags).postTags(postTags))
                        .withPageable(PageRequest.of(page, pageSize))
                        .build();
        Flux<SearchHit<FilmList>> searchHitFlux = elasticsearchOperations.search(searchQuery, FilmList.class, index);

        Iterator<SearchHit<FilmList>> filmListIterator = searchHitFlux.toIterable().iterator();
        while (filmListIterator.hasNext()) {
            SearchHit<FilmList> searchHit = filmListIterator.next();
            FilmList filmList = searchHit.getContent();
            Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
            // 遍历打印
            // highlightFields.keySet().forEach(key -> System.out.println("map.get(" + key + ") = " + highlightFields.get(key)));
            // 替换字段
            highlightFields.keySet().forEach(key -> filmList.setDescription(String.valueOf(highlightFields.get(key))));
            filmListList.add(filmList);
        }
        for (FilmList filmList : filmListList) {
            log.info("filmList:{}", filmList);
        }
    }

```