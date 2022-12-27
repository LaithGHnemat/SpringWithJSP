
		setInterval(function() {
			date = new Date();
			seconds = date.getSeconds();
			menit = date.getMinutes();
			jam = date.getHours();
			hari = date.getDay();
			tanggal = date.getDate();
			bulan = date.getMonth();
			tahun = date.getFullYear();
			document.getElementById('date').innerHTML =
					  jam + " : "
					+ menit + " : " + seconds;
		}, 1000);