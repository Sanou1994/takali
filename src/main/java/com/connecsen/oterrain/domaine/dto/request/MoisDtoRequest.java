package com.connecsen.oterrain.domaine.dto.request;

import com.connecsen.oterrain.domaine.Terrain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class MoisDtoRequest {
	private String jour;
	private boolean o00h01h;
	private boolean o01h02h;
	private boolean o02h03h;
	private boolean o03h04h;
	private boolean o04h05h;
	private boolean o05h06h;
	private boolean o06h07h;
	private boolean o07h08h;
	private boolean o08h09h;
	private boolean o09h10h;
	private boolean o10h11h;
	private boolean o11h12h;
	private boolean o12h13h;
	private boolean o13h14h;
	private boolean o14h15h;
	private boolean o15h16h;
	private boolean o16h17h;
	private boolean o17h18h;
	private boolean o18h19h;
	private boolean o19h20h;
	private boolean o20h21h;
	private boolean o21h22h;
	private boolean o22h23h;
	private boolean o23h24h;
	private Terrain terrain;
}
