using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace DemoCSharp
{
    class Program
    {
        static void Main(string[] args)
        {
            string tenHocSinh = "";
            double diemToan = 0.0;
            double diemVan = 0.0;
            double diemAnh = 0.0;
            double diemTin = 0.0;
            double diemTrungBinh = 0.0;

            Console.WriteLine("**************** CHUONG TRINH TINH DIEM TRUNG BINH **********");
            Console.WriteLine("Hay nhap vao ho ten");
            tenHocSinh = Console.ReadLine();

            Console.WriteLine("Hay nhap vao diem TOAN");
            diemToan = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Hay nhap vao diem VAN");
            diemVan = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Hay nhap vao diem ANH");
            diemAnh = Convert.ToDouble(Console.ReadLine());

            Console.WriteLine("Hay nhap vao ho TIN");
            diemTin = Convert.ToDouble(Console.ReadLine());

            diemTrungBinh = ((diemToan + diemVan + diemAnh) * 2 + diemTin) / 7;

            Console.WriteLine("Hoc sinh {0} co diem trung binh la {1} ",tenHocSinh, diemTrungBinh);
            Console.ReadLine();
        }
    }
}
