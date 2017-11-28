package com.es.movie.mapper;

import java.util.Date;
import java.util.List;

import com.es.movie.vo.Seat;
import com.es.movie.vo.SeatDisabled;
import com.es.movie.vo.SeatInfo;
import com.es.movie.vo.SelectTimetable;
import com.es.pos.vo.Ticket;

public interface ScreenMapper {
	//id�� seat���� ��ȸ
	Seat getSeatBySeatId(int seatId);
	
	//screenId�� ��� Seat ��ȸ
	List<Seat> getSeatsByScreenId(int screenId);
	
	int getDisabledSeatsByScreenId(int screenId);
	
	//id�� ���༮��ȸ
	List<Ticket> getReservedSeatsByTimetableId(int timetalbleId);
	
	
	
	
	
	//�¼����� ���༮ Ŭ���� �¼�����
	List<SeatInfo> getSeatInfoBySeatId(SeatInfo seatInfo);
	
	
	
	
	
	//Ȯ���¼� �߰�
	void insertSeatDissabled(SeatDisabled seatDisabled);
	
	//�¼�Ȯ�� ���º���
	void updateSeatStatus(Seat seat);
	
	//Ȯ���¼� ������
	SeatDisabled getDisabledDetail(int seatId); 
	
	
}
