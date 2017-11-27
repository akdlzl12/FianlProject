package com.es.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.es.common.mapper.HomeMainMapper;
import com.es.common.vo.MonthDate;
import com.es.common.vo.MovieRankNameForm;
import com.es.common.vo.OnlineOfflinePaymentMetrics;

@Service
public class HomeMainImpl implements HomeMainService{

	@Autowired
	private HomeMainMapper homeMainMapper; 
	
	@Override
	public List<MovieRankNameForm> getMovieRankName(MonthDate monthDate) {
		return homeMainMapper.getMovieRankName(monthDate);
	}
	
	@Override
	public List<MovieRankNameForm> getMovieAudienceStatisticsSelect(MonthDate monthDate) {
		return homeMainMapper.getMovieAudienceStatisticsSelect(monthDate);
	}
	
	@Override
	public List<MovieRankNameForm> getMostFeaturedFilms(MonthDate monthDate) {
		return homeMainMapper.getMostFeaturedFilms(monthDate);
	}
	
	@Override
	public List<OnlineOfflinePaymentMetrics> getOnlineOfflinePaymentMetrics(MonthDate monthDate) {
		return homeMainMapper.getOnlineOfflinePaymentMetrics(monthDate);
	}
}
