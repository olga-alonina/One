package io.fleet.utilities;

public final class Exel_Util {
/*
    private static final Logger LOG = LogManager.getLogger( Exel_Util.class);

    private static Workbook workbook;
    private static Sheet workSheet;
    private static String path;

    private Exel_Util() {
        throw new IllegalStateException("Utility class");
    }

    public static void readFromExcel(String downloadDir, String fileName, String sheetName) throws IOException {
        DataFormatter dataFormatter = new DataFormatter();
        // Create an object of File class to open xlsx file
        String filePath = FilenameUtils.normalize(downloadDir + File.separator + fileName);
        File file = new File(filePath);
        // Create an object of FileInputStream class to read excel file
        try (FileInputStream inputStream = new FileInputStream(file)) {
            // Find the file extension by splitting file name in substring and getting only extension name
            String fileExtensionName = fileName.substring(fileName.indexOf("."));
            if (".xlsx".equals(fileExtensionName)) {
                // If it is xlsx file then create object of XSSFWorkbook class
                try (Workbook workbook = new XSSFWorkbook(inputStream)) {
                    // Read sheet inside the workbook by its name
                    workSheet = workbook.getSheet(sheetName);
                    workSheet.forEach(row -> row.forEach((Cell cell) -> {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        LOG.debug(cellValue);
                    }));
                }
            }
            if (".xls".equals(fileExtensionName)) {
                // If it is xls file then create object of HSSFWorkbook class
                try (Workbook workbook = new HSSFWorkbook(inputStream)) {
                    // Read sheet inside the workbook by its name
                    workSheet = workbook.getSheet(sheetName);
                    workSheet.forEach(row -> row.forEach((Cell cell) -> {
                        String cellValue = dataFormatter.formatCellValue(cell);
                        LOG.debug(cellValue);
                    }));
                }
            }
        }
    }

    public static String getCellData(int rowNum, int colNum) {
        DataFormatter dataFormatter = new DataFormatter();
        LOG.info("Getting cell data..");
        Cell cell;
        try {
            cell = workSheet.getRow(rowNum).getCell(colNum);
            return dataFormatter.formatCellValue(cell);
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[][] getDataArray() {
        LOG.info("Getting data in 2 dimensional array..");
        String[][] data = new String[rowCount()][columnCount()];
        for (int i = 0; i < rowCount(); i++) {
            for (int j = 0; j < columnCount(); j++) {
                String value = getCellData(i, j);
                data[i][j] = value;
            }
        }
        return data;

    }

    public static List<String> getColumnsNames() {
        DataFormatter dataFormatter = new DataFormatter();
        LOG.info("Getting the column names as a list..");
        List<String> columns = new ArrayList<>();

        for (Cell cell : workSheet.getRow(0)) {
            columns.add(dataFormatter.formatCellValue(cell));
        }
        return columns;
    }

    public static List<Map<String, String>> getDataList() {
        DataFormatter dataFormatter = new DataFormatter();
        // get all columns
        List<String> columns = getColumnsNames();
        // this will be returned
        List<Map<String, String>> data = new ArrayList<>();

        for (int i = 1; i <= rowCount(); i++) {
            // get each row
            Row row = workSheet.getRow(i);
            // create map of the row using the column and value
            // column name --> map key, cell value --> map value
            Map<String, String> rowMap = new HashMap<>();
            for (Cell cell : row) {
                int columnIndex = cell.getColumnIndex();
                rowMap.put(columns.get(columnIndex), dataFormatter.formatCellValue(cell, null, null));
            }

            data.add(rowMap);
        }

        return data;
    }

    public static void setCellData(String value, int rowNum, int colNum) {
        LOG.info("Setting the Cell: [{}] row number: [{}] with this value [{}]", colNum, rowNum, value);
        Cell cell;
        Row row;

        try {
            row = workSheet.getRow(rowNum);
            cell = row.getCell(colNum);

            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.flush();

            fileOut.close();
        } catch (IOException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }

    public static void setCellData(String value, String columnName, int row) {
        LOG.info("Setting the column name: [{}] row number: [{}] with this value [{}]", columnName, row, value);
        int column = getColumnsNames().indexOf(columnName);
        setCellData(value, row, column);
    }

    public static int columnCount() {
        LOG.debug("Counting the total number of columns exist..");
        return workSheet.getRow(0).getLastCellNum();
    }

    public static int rowCount() {
        LOG.debug("Counting the total number of rows exist..");
        return workSheet.getLastRowNum();
    }

 */
}