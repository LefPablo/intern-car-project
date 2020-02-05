package org.rent.cr.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.List;

@Component
public class VueTablePageDto<T> {
    @Autowired
    private ServletContext servletContext;

    private Integer total;

    @JsonProperty("per_page")
    private Integer perPage;

    @JsonProperty("current_page")
    private Integer currentPage;

    @JsonProperty("last_page")
    private Integer lastPage;

    @JsonProperty("next_page_url")
    private String nextPageUrl;

    @JsonProperty("prev_page_url")
    private String prevPageUrl;

    private Integer from;
    private Integer to;
    private List<T> data;

    public VueTablePageDto() {
    }

    public VueTablePageDto <T>pageToVueTablePage(Page<T> page) {
        VueTablePageDto<T> vueTablePage = new VueTablePageDto<>();
        vueTablePage.setTotal(page.getNumberOfElements());
        vueTablePage.setPerPage(page.getSize());
        vueTablePage.setCurrentPage(page.getNumber());
        vueTablePage.setLastPage(page.getTotalPages());
        vueTablePage.setPrevPageUrl(servletContext.getContextPath() + "");
        vueTablePage.setNextPageUrl(servletContext.getContextPath() + "");

        Integer from = page.getSize() * page.getNumber() + 1;;
        if (from > page.getNumberOfElements())
            from = null;
        Integer to = null;

        if (from > page.getNumberOfElements())
            from = null;
        else
            to = from - 1 + page.getSize(); // minus one because last element inclusive

        vueTablePage.setFrom(from);
        vueTablePage.setTo(to);
        return vueTablePage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }

    public void setNextPageUrl(String nextPageUrl) {
        this.nextPageUrl = nextPageUrl;
    }

    public String getPrevPageUrl() {
        return prevPageUrl;
    }

    public void setPrevPageUrl(String prevPageUrl) {
        this.prevPageUrl = prevPageUrl;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
