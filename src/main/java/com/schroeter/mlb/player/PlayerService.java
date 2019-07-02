package com.schroeter.mlb.player;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private RemoteMlbService remoteMlbService;

    public PlayerResource getPlayer() {
        //Call MLB player info service
//        PlayerResource playerResource = remoteMlbService.getPlayer("493316");
        //call MLB player stat service

        // map to playerResource
        PlayerResource playerResource = new PlayerResource();
        playerResource.setChosen(false);
        playerResource.setFirstName("Carl");
        playerResource.setLastName("Smith");
        playerResource.setPosition("1B");
        playerResource.setBatPosition("L");
        playerResource.setThrowPosition("L");
        playerResource.setTeamName("New York Mets");
        playerResource.setHomeRuns(17);
        playerResource.setHits(85);
        playerResource.setRuns(46);
        playerResource.setAtBats(291);
        playerResource.setTotalBases(157);
        playerResource.setWalks(26);
        playerResource.setStrikeouts(61);
        playerResource.setBatAvg((float).292);
        playerResource.setSlugPercentage((float).540);
        playerResource.setOnBasePercentage((float).352);
        playerResource.setPitchesPerPlateAppearance((float)4.10);
        playerResource.setRunsCreated((float) playerResource.totalBases * (((float) playerResource.hits) + (float) playerResource.walks) / (((float) playerResource.atBats)
                                        + (float) playerResource.walks));
        playerResource.setHeightFeet(0);
        playerResource.setHeightInches(0);

        return playerResource;
    }

//    public ByteArrayInputStream createPlayerXls(List<PlayerResource> playerResources) throws IOException {
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

                    row.createCell(0).setCellValue(playerResource.getFirstName());
                    row.createCell(1).setCellValue(playerResource.getLastName());
                    row.createCell(2).setCellValue(playerResource.getPosition());
                    row.createCell(3).setCellValue(playerResource.getBatPosition());
                    row.createCell(4).setCellValue(playerResource.getThrowPosition());
                    row.createCell(5).setCellValue(playerResource.getTeamName());
                    row.createCell(6).setCellValue(playerResource.getHomeRuns());
                    row.createCell(7).setCellValue(playerResource.getRuns());
                    row.createCell(8).setCellValue(playerResource.getAtBats());
                    row.createCell(9).setCellValue(playerResource.getWalks());
                    row.createCell(10).setCellValue(playerResource.getBatAvg());
                    row.createCell(11).setCellValue(playerResource.getSlugPercentage());
                    row.createCell(12).setCellValue(playerResource.getOnBasePercentage());
                }

            }

            workbook.write(out);
//            return new ByteArrayInputStream(out.toByteArray());
            return out.toByteArray();
        }
    }

    public List<PlayerResource> getPlayers() {
        List<PlayerResource> playerResourceList = new ArrayList<>();
        playerResourceList.add(getPlayer());
        playerResourceList.add(getPlayer());
        playerResourceList.add(getPlayer());
        return playerResourceList;
    }
}
