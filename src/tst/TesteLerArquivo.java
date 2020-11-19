package tst;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import app.Parser;
import expts.ArquivoNaoEncontradoException;

public class TesteLerArquivo {

	@Test
	public void TesteLerArquivoSucessoTotalTime() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		@SuppressWarnings("serial")
		List<List<Integer>> array = new ArrayList<List<Integer>>() {{
		    add(Arrays.asList(776, 1102, 1121, 1134, 1161, 1204, 1070, 1140, 1157, 1091));
			add(Arrays.asList(831, 1205, 1164, 1069, 1287, 1173, 1129, 1200, 1181, 1116));
			add(Arrays.asList(786, 1180, 1134, 1085, 1302, 1381, 1164, 1389, 1114, 1175));
			add(Arrays.asList(790, 1241, 1126, 1140, 1188, 1268, 1155, 1143, 1158, 1077));
			add(Arrays.asList(799, 1145, 1137, 1117, 1271, 1290, 1216, 1149, 1207, 1072));
			add(Arrays.asList(824, 1170, 1109, 1180, 1251, 1171, 1171, 1297, 1169, 1099));
			add(Arrays.asList(795, 1137, 1225, 1167, 1178, 1232, 1154, 1177, 1134, 1208));
			add(Arrays.asList(844, 1091, 1201, 1138, 1140, 1191, 1098, 1174, 1235, 1121));
			add(Arrays.asList(840, 1208, 1265, 1225, 1155, 1205, 1131, 1276, 1146, 1203));
			add(Arrays.asList(849, 1170, 1211, 1184, 1228, 1142, 1198, 1204, 1158, 1170));
			add(Arrays.asList(852, 1463, 1202, 1218, 1241, 1112, 1189, 1266, 1244, 1162));
			add(Arrays.asList(883, 1520, 1213, 1172, 1196, 1316, 1272, 1347, 1296, 1331));
			add(Arrays.asList(880, 1199, 1438, 1352, 1275, 1195, 1348, 1228, 1223, 1203));
			add(Arrays.asList(1065, 1312, 1379, 1207, 1343, 1291, 1148, 1269, 1268, 1255)); 
			add(Arrays.asList(1386, 1222, 1218, 1219, 1149, 1418, 1297, 1243, 1239, 1229)); 
			add(Arrays.asList(1342, 1350, 1236, 1333, 1363, 1391, 1299, 1432, 1394, 1254)); 
			add(Arrays.asList(1317, 1302, 1405, 1430, 1427, 1480, 1275, 1255, 1320, 1374)); 
			add(Arrays.asList(1344, 1270, 1231, 1280, 1283, 1357, 1321, 1278, 1290, 1348)); 
			add(Arrays.asList(1258, 1329, 1298, 1332, 1251, 1308, 1371, 1319, 1331, 1306)); 
			add(Arrays.asList(1337, 1338, 1232, 1260, 1408, 1341, 1290, 1357, 1274, 1323));
        }};
		
		parser.lerArquivo("assets/totalTime.out");
		
		assertEquals(array, parser.getBuffer());
	}
	
	@Test
	public void TesteLerArquivoSucessoAnalysisTime() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		@SuppressWarnings("serial")
		List<List<Integer>> array = new ArrayList<List<Integer>>() {{
		    add(Arrays.asList(439, 705, 738, 729, 752, 740, 658, 713, 765, 710));
			add(Arrays.asList(470, 828, 760, 668, 884, 721, 720, 802, 777, 735));
			add(Arrays.asList(446, 789, 763, 692, 910, 966, 751, 1002, 720, 752));
			add(Arrays.asList(457, 852, 739, 710, 763, 838, 761, 763, 742, 699));
			add(Arrays.asList(472, 734, 726, 708, 817, 811, 763, 757, 789, 678));
			add(Arrays.asList(470, 760, 701, 764, 849, 747, 771, 884, 757, 669));
			add(Arrays.asList(462, 737, 714, 729, 788, 836, 687, 772, 694, 776));
			add(Arrays.asList(509, 696, 738, 710, 758, 763, 689, 764, 804, 717));
			add(Arrays.asList(500, 753, 808, 778, 739, 812, 724, 846, 740, 746));
			add(Arrays.asList(493, 740, 717, 728, 839, 722, 736, 810, 703, 756));
			add(Arrays.asList(466, 1013, 748, 773, 809, 730, 727, 787, 771, 710));
			add(Arrays.asList(514, 1060, 771, 754, 766, 903, 792, 930, 829, 856));
			add(Arrays.asList(506, 784, 977, 904, 872, 774, 875, 811, 774, 756));
			add(Arrays.asList(676, 876, 905, 762, 929, 825, 728, 853, 822, 798));
			add(Arrays.asList(919, 804, 783, 769, 760, 908, 887, 802, 783, 797));
			add(Arrays.asList(897, 896, 805, 839, 914, 834, 853, 996, 913, 822));
			add(Arrays.asList(862, 846, 970, 999, 982, 1003, 848, 819, 871, 925));
			add(Arrays.asList(865, 810, 791, 865, 830, 851, 860, 847, 855, 892));
			add(Arrays.asList(835, 875, 866, 875, 820, 833, 928, 901, 870, 836));
			add(Arrays.asList(874, 896, 809, 827, 962, 849, 873, 907, 845, 896));
		}};
		
		parser.lerArquivo("assets/analysisTime.out");
		
		assertEquals(array, parser.getBuffer());
	}
	
	@Test
	public void TesteLerArquivoVazio() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();

		List<List<Integer>> array = new ArrayList<List<Integer>>();
		
		parser.lerArquivo("assets/arquivoVazio.out");
		
		assertEquals(array, parser.getBuffer());
	}
	
	@Test(expected=ArquivoNaoEncontradoException.class)
	public void TesteLerArquivoInexistente() throws ArquivoNaoEncontradoException {
		Parser parser = new Parser();
		
		parser.lerArquivo("assets/arquivoInexistente.out");
	}

}
