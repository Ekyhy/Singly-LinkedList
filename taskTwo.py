class Node:
    def __init__(self, nimMahasiswa, namaMahasiswa):
        self.nimMahasiswa = nimMahasiswa
        self.namaMahasiswa = namaMahasiswa
        self.next = None

class linkedListMahasiswa:
    def __init__(self):
        self.head = None

    def insertAtFront(self, nimMahasiswa, namaMahasiswa):
        new_node = Node(nimMahasiswa,namaMahasiswa)
        new_node.next = self.head
        self.head = new_node

    def insertFromGivenPosistion(self,position, nimMahasiswa, namaMahasiswa):
        total = self.count_head()

        if position < 1 or position > total + 1:
            print("Posisi Tidak Valid!")
            return
        
        new_node = Node (nimMahasiswa,namaMahasiswa)
        
        if position == 1:
            new_node.next = self.head
            self.head = new_node
            return
        
        current = self.head
        count = 1

        while count < position - 1:
            current = current.next
            count += 1
        new_node.next = current.next
        current.next = new_node

    def insertFromEnd(self, nimMahasiswa, namaMahasiswa):
        new_node = Node(nimMahasiswa, namaMahasiswa)
        position = self.head
        if position is None:
            position =  new_node
            return  
        last_node = position
        while last_node.next is not None:
            last_node = last_node.next   
        last_node.next = new_node

    def deleteFromBeginning(self):
        if self.head is None:
            print("Data Mahasiswa Kosong!")
            return
        temp = self.head
        self.head = temp.next
        temp = None

    def deleteFromEnd(self):
        self.head
        if self.head is None:
            print("Data Mahasiswa Kosong!")
            return
        
        if self.head.next is None:
            print("Data Pertama Sudah Dihapus!")
            return
        
        last_node = self.head
        while last_node.next.next is not None:
            last_node = last_node.next
        last_node.next = None

    def deleteFromGivenPosition(self, position):
        temp = self.head
        previous =  None

        if position == 1:
            self.head = temp.next
            return

        for i in range(1, position):
            previous = temp
            temp = temp.next

        previous.next = temp.next
        print(f"Mahasiswa Terhapus: {temp.nimMahasiswa}, {temp.namaMahasiswa}")

    def deleteFromGivenNIM(self,nimMahasiswa):
        if self.head is None:
            print("Data Mahasiswa Kosong!")
            return
        if self.head.nimMahasiswa == nimMahasiswa:
            temp = self.head
            self.head = temp.next
            print(f"Data Mahasiswa {temp.nimMahasiswa}, {temp.namaMahsiswa} Telah Terhapus!")
            return
        
        current = self.head
        previous = None

        while current is not None and current.nimMahasiswa != nimMahasiswa:
            previous = current
            current = current.next

        if current is None:
            print("NIM Tidak Ditemukan")
            return
        
        previous.next = current.next
        print(f"Data Mahasiswa {current.nimMahasiswa}, {current.namaMahasiswa} Telah Dihapus!")

    def showDataMahasiswa(self):
        curr = self.head

        if curr is None:
            print("Data Kosong!")
            return
        
        while curr is not None:
            print(f"NIM: {curr.nimMahasiswa}, Nama: {curr.namaMahasiswa}")
            curr = curr.next

    def count_head(self):
        count = 0
        curr = self.head

        while curr is not None:
            count += 1
            curr = curr.next
        return count

        
    

if __name__ == "__main__":

    ll = linkedListMahasiswa()

    while True:
        print("\n====== Menu Program Olah Data Mahasiswa ======")
        print("1.  Data baru ditempatkan di depan: ")
        print("2.  Data baru ditempatkan di posisi sesuai pilihan (1 - count + 1): ")
        print("3.  Data baru ditempatkan di belakang: ")
        print("4.  Hapus data dari depan: ")
        print("5.  Hapus data di posisi sesuai pilihan (1 - count): ")
        print("6.  Hapus data paling belakang: ")
        print("7.  Hapus data mahasiswa berdasarkan input user (NIM): ")
        print("8.  Tampilkan Data Mahasiswa: ")
        print("9.  Hitung Jumlah Data: ")
        print("10. Keluar: ")

        choice = input("Pilih Menu: ")

        if choice == "1":
            inpNimMahasiswa = input("Masukkan NIM Mahasiswa: ")
            inpNamaMahasiswa = input("Masukkan Nama Mahasiswa: ")
            ll.insertAtFront(inpNimMahasiswa,inpNamaMahasiswa)

        elif choice == "2":
            inpIndexMahasiswa = int(input(f"Masukkan Lokasi Urutan Data yang Di Pilih [0 - {ll.count_head() + 1 }]: "))
            inpNimMahasiswa = input("Masukkan NIM Mahasiswa: ")
            inpNamaMahasiswa = input("Masukkan Nama Mahasiswa: ")

            ll.insertFromGivenPosistion(inpIndexMahasiswa, inpNimMahasiswa, inpNamaMahasiswa)

        elif choice == "3":
            inpNimMahasiswa = input("Masukkan NIM Mahasiswa: ")
            inpNamaMahasiswa = input("Masukkan Nama Mahasiswa: ")

            ll.insertFromEnd(inpNimMahasiswa,inpNamaMahasiswa)

        elif choice == "4":
            ll.deleteFromBeginning()

        elif choice == "5":
            inpIndexMahasiswa = int(input(f"Masukkan Lokasi Urutan Data yang Di Delete [1 - {ll.count_head()}]: "))
            ll.deleteFromGivenPosition(inpIndexMahasiswa)

        elif choice == "6":
            ll.deleteFromEnd()

        elif choice == "7":
            inpNimMahasiswaDelete = input("Masukkan NIM Mahasiswa yang Akan Dihapus: ")
            ll.deleteFromGivenNIM(inpNimMahasiswaDelete)
        elif choice == "8":
            print("Data Mahasiswa Saat Ini: ")
            ll.showDataMahasiswa()

        elif choice == "9":
            print("Jumlah Data", ll.count_head())

        elif choice == "10":
            break

        else:
            print("Pilihan Tidak Valid!")