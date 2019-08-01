package com.schroeter.mlb.player;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schroeter.mlb.player.remoteMlbService.RemoteMlbService;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private RemoteMlbService remoteMlbService;

    public byte[] createPlayerXls(List<PlayerResource> playerResources) throws IOException {
        String[] COLUMNs = {"First Name", "Last Name", "Position", "Bat Position", "Throw Position", "Team Name", "Home Runs",
                            "Runs", "At Bats", "Walks", "Batting Average", "Slugging Percentage", "On Base Percentage"};
        try(
                Workbook workbook = new XSSFWorkbook();
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ){
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Players");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < COLUMNs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(COLUMNs[col]);
                cell.setCellStyle(headerCellStyle);
            }

            // CellStyle for Age
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (PlayerResource playerResource : playerResources) {
                if (playerResource.chosen == true) {
                    Row row = sheet.createRow(rowIdx++);
                    
                    setCell(row, 0, playerResource.getFirstName());
                    setCell(row, 1, playerResource.getLastName());
                    setCell(row, 2, playerResource.getPosition());
                    setCell(row, 3, playerResource.getBatPosition());
                    setCell(row, 4, playerResource.getThrowPosition());
                    setCell(row, 5, playerResource.getTeamName());
                    setCell(row, 6, playerResource.getHomeRuns());
                    setCell(row, 7, playerResource.getRuns());
                    setCell(row, 8, playerResource.getAtBats());
                    setCell(row, 9, playerResource.getWalks());
                    setCell(row, 10, playerResource.getBatAvg());
                    setCell(row, 11, playerResource.getSlugPercentage());
                    setCell(row, 12, playerResource.getOnBasePercentage());
                }

            }

            workbook.write(out);
            return out.toByteArray();
        }
    }
    
    private void setCell(Row row, int columnIndex, String value) {
    	if (value != null) {
    		row.createCell(columnIndex).setCellValue(value);
    	} else {
    		row.createCell(columnIndex).setCellValue("0");
    	}
    }
    
    private void setCell(Row row, int columnIndex, Float value) {
    	if (value != null) {
    		row.createCell(columnIndex).setCellValue(value);
    	} else {
    		row.createCell(columnIndex).setCellValue("0");
    	}
    }
    
    private void setCell(Row row, int columnIndex, Integer value) {
    	if (value != null) {
    		row.createCell(columnIndex).setCellValue(value);
    	} else {
    		row.createCell(columnIndex).setCellValue("0");
    	}
    }

    public List<PlayerResource> getTeamRoster(String teamId) {
    	List<PlayerResource> playerResourceList = remoteMlbService.getTeamRoster(teamId);
    	remoteMlbService.getTeamStats(playerResourceList);
        return playerResourceList;
    }
}
