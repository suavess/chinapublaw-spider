package com.suave.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Suave
 * @date 2022/11/10 11:04
 */
@NoArgsConstructor
@Data
public class InitialStateEntity {

    @JSONField(name = "common")
    private CommonDTO common;
    @JSONField(name = "home")
    private HomeDTO home;
    @JSONField(name = "search")
    private SearchDTO search;
    @JSONField(name = "rank")
    private RankDTO rank;
    @JSONField(name = "page")
    private PageDTO page;
    @JSONField(name = "reader")
    private ReaderDTO reader;
    @JSONField(name = "preview")
    private PreviewDTO preview;
    @JSONField(name = "welfare")
    private WelfareDTO welfare;
    @JSONField(name = "theme")
    private ThemeDTO theme;
    @JSONField(name = "seo")
    private SeoDTO seo;

    @NoArgsConstructor
    @Data
    public static class CommonDTO {
        @JSONField(name = "id")
        private String id;
        @JSONField(name = "mediaId")
        private String mediaId;
        @JSONField(name = "hasSerialPermission")
        private Boolean hasSerialPermission;
        @JSONField(name = "hasAuthentication")
        private Boolean hasAuthentication;
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "avatar")
        private String avatar;
        @JSONField(name = "isLoginModalVisible")
        private Boolean isLoginModalVisible;
        @JSONField(name = "callbackUrl")
        private String callbackUrl;
        @JSONField(name = "isLoading")
        private Boolean isLoading;
        @JSONField(name = "needUpdate")
        private Boolean needUpdate;
        @JSONField(name = "isShowLogin")
        private Boolean isShowLogin;
        @JSONField(name = "hasRegistered")
        private Boolean hasRegistered;
        @JSONField(name = "needLogout")
        private Boolean needLogout;
        @JSONField(name = "css")
        private String css;
    }

    @NoArgsConstructor
    @Data
    public static class HomeDTO {
        @JSONField(name = "serverRendered")
        private Boolean serverRendered;
        @JSONField(name = "noticeList")
        private Object noticeList;
        @JSONField(name = "bannerList")
        private Object bannerList;
        @JSONField(name = "writerList")
        private Object writerList;
        @JSONField(name = "editorList")
        private Object editorList;
        @JSONField(name = "weekList")
        private Object weekList;
        @JSONField(name = "boyList")
        private Object boyList;
        @JSONField(name = "girlList")
        private Object girlList;
        @JSONField(name = "subscribeList")
        private Object subscribeList;
        @JSONField(name = "workhardList")
        private Object workhardList;
        @JSONField(name = "newbookList")
        private Object newbookList;
        @JSONField(name = "updateList")
        private Object updateList;
        @JSONField(name = "cityList")
        private Object cityList;
        @JSONField(name = "fantasyList")
        private Object fantasyList;
        @JSONField(name = "minorityMaleList")
        private Object minorityMaleList;
        @JSONField(name = "presentWordsList")
        private Object presentWordsList;
        @JSONField(name = "oldSayingList")
        private Object oldSayingList;
        @JSONField(name = "minorityFemaleList")
        private Object minorityFemaleList;
        @JSONField(name = "maleRenderString")
        private String maleRenderString;
        @JSONField(name = "femaleRenderString")
        private String femaleRenderString;
    }

    @NoArgsConstructor
    @Data
    public static class SearchDTO {
        @JSONField(name = "searchBookList")
        private Object searchBookList;
        @JSONField(name = "authorData")
        private Object authorData;
        @JSONField(name = "total")
        private Integer total;
        @JSONField(name = "loading")
        private Boolean loading;
    }

    @NoArgsConstructor
    @Data
    public static class RankDTO {
        @JSONField(name = "serverRendered")
        private Boolean serverRendered;
        @JSONField(name = "book_list")
        private Object bookList;
        @JSONField(name = "defaultPage")
        private Integer defaultPage;
        @JSONField(name = "total_num")
        private Integer totalNum;
        @JSONField(name = "rankVersion")
        private String rankVersion;
        @JSONField(name = "rankTypeText")
        private String rankTypeText;
        @JSONField(name = "loading")
        private Boolean loading;
    }

    @NoArgsConstructor
    @Data
    public static class PageDTO {
        @JSONField(name = "hasFetch")
        private Boolean hasFetch;
        @JSONField(name = "author")
        private String author;
        @JSONField(name = "authorId")
        private String authorId;
        @JSONField(name = "bookId")
        private String bookId;
        @JSONField(name = "mediaId")
        private String mediaId;
        @JSONField(name = "bookName")
        private String bookName;
        @JSONField(name = "status")
        private Integer status;
        @JSONField(name = "category")
        private String category;
        @JSONField(name = "categoryV2")
        private String categoryV2;
        @JSONField(name = "abstract")
        private String abstractX;
        @JSONField(name = "thumbUri")
        private String thumbUri;
        @JSONField(name = "creationStatus")
        private Integer creationStatus;
        @JSONField(name = "wordNumber")
        private Integer wordNumber;
        @JSONField(name = "readCount")
        private Integer readCount;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "avatarUri")
        private String avatarUri;
        @JSONField(name = "creatorId")
        private String creatorId;
        @JSONField(name = "lastPublishTime")
        private String lastPublishTime;
        @JSONField(name = "lastChapterItemId")
        private String lastChapterItemId;
        @JSONField(name = "lastChapterTitle")
        private String lastChapterTitle;
        @JSONField(name = "volumeNameList")
        private List<String> volumeNameList;
        @JSONField(name = "chapterListWithVolume")
        private List<List<ChapterListWithVolumeDTO>> chapterListWithVolume;
        @JSONField(name = "chapterTotal")
        private Integer chapterTotal;
        @JSONField(name = "followStatus")
        private Integer followStatus;
        @JSONField(name = "itemIds")
        private List<String> itemIds;
        @JSONField(name = "hasFetchDirectory")
        private Boolean hasFetchDirectory;
        @JSONField(name = "chapterList")
        private List<?> chapterList;
        @JSONField(name = "serverRendered")
        private Boolean serverRendered;
        @JSONField(name = "authorName")
        private String authorName;
        @JSONField(name = "completeCategory")
        private String completeCategory;
        @JSONField(name = "platform")
        private String platform;

        @NoArgsConstructor
        @Data
        public static class ChapterListWithVolumeDTO {
            @JSONField(name = "itemId")
            private String itemId;
            @JSONField(name = "needPay")
            private Integer needPay;
            @JSONField(name = "title")
            private String title;
        }
    }

    @NoArgsConstructor
    @Data
    public static class ReaderDTO {
        @JSONField(name = "phoneUrl")
        private String phoneUrl;
        @JSONField(name = "chapterData")
        private ReaderDTO.ChapterDataDTO chapterData;
        @JSONField(name = "preChapterData")
        private ReaderDTO.PreChapterDataDTO preChapterData;
        @JSONField(name = "nextChapterData")
        private ReaderDTO.NextChapterDataDTO nextChapterData;
        @JSONField(name = "catalogData")
        private ReaderDTO.CatalogDataDTO catalogData;

        @NoArgsConstructor
        @Data
        public static class ChapterDataDTO {
        }

        @NoArgsConstructor
        @Data
        public static class PreChapterDataDTO {
        }

        @NoArgsConstructor
        @Data
        public static class NextChapterDataDTO {
        }

        @NoArgsConstructor
        @Data
        public static class CatalogDataDTO {
        }
    }

    @NoArgsConstructor
    @Data
    public static class PreviewDTO {
        @JSONField(name = "chapterData")
        private Object chapterData;
    }

    @NoArgsConstructor
    @Data
    public static class WelfareDTO {
        @JSONField(name = "serverRendered")
        private Boolean serverRendered;
        @JSONField(name = "editorList")
        private Object editorList;
    }

    @NoArgsConstructor
    @Data
    public static class ThemeDTO {
        @JSONField(name = "header")
        private ThemeDTO.HeaderDTO header;

        @NoArgsConstructor
        @Data
        public static class HeaderDTO {
            @JSONField(name = "bg")
            private String bg;
            @JSONField(name = "theme")
            private Integer theme;
            @JSONField(name = "isDefault")
            private Boolean isDefault;
        }
    }

    @NoArgsConstructor
    @Data
    public static class SeoDTO {
        @JSONField(name = "voteLinkList")
        private List<?> voteLinkList;
    }
}

