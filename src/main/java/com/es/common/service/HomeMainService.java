package com.es.common.service;

import java.util.List;

import com.es.common.vo.MonthDate;
import com.es.common.vo.MovieRankNameForm;
import com.es.common.vo.OnlineOfflinePaymentMetrics;

public interface HomeMainService {
	
	
	List<MovieRankNameForm> getMovieRankName(MonthDate monthDate);
	List<MovieRankNameForm> getMovieAudienceStatisticsSelect(MonthDate monthDate);
	List<MovieRankNameForm> getMostFeaturedFilms(MonthDate monthDate);
	List<OnlineOfflinePaymentMetrics> getOnlineOfflinePaymentMetrics(MonthDate monthDate);
}
